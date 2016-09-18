package client;

import server.Database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Book {
	private JFrame book;
	private DefaultTableModel tableModel; // 表格模型对象
	int b;

	Database data_book;
	String[] columnNames;
	String[][] bookdata;
	private JTable table;
	String id, name, sex, pnum, idcard, rnum, day, money, ps;
	Date oldDate = null;

	// 预定信息界面
	public Book() {
		data_book = new Database();

		book = new JFrame("预定信息");
		book.setSize(new Dimension(600, 400));
		book.setLocation(new Point(300, 150));
		book.getContentPane().setLayout(null);
		b = data_book.getBookNum();
		JLabel booknum = new JLabel("当前预定数:" + b);
		booknum.setForeground(Color.ORANGE);
		booknum.setBounds(10, 10, 119, 34);
		book.getContentPane().add(booknum);

		columnNames = new String[] { "预定号", "姓名", "性别", "手机号", "身份证号", "房间号",
				"天数", "保留时间", "金额", "备注", };
		bookdata = data_book.bookData();
		tableModel = new DefaultTableModel(bookdata, columnNames);
		table = new JTable(tableModel);
		table.setForeground(new Color(106, 90, 205));
		table.setGridColor(SystemColor.textHighlight);
		// 设置各列的宽度，是内容能较好的呈现
		// bid
		TableColumn column1 = table.getColumnModel().getColumn(0);
		column1.setPreferredWidth(50);
		// bname
		TableColumn column2 = table.getColumnModel().getColumn(1);
		column2.setPreferredWidth(60);
		// bsex
		TableColumn column3 = table.getColumnModel().getColumn(2);
		column3.setPreferredWidth(33);
		// bpnum
		TableColumn column4 = table.getColumnModel().getColumn(3);
		column4.setPreferredWidth(110);
		// bidacard
		TableColumn column5 = table.getColumnModel().getColumn(4);
		column5.setPreferredWidth(165);
		// brnum
		TableColumn column6 = table.getColumnModel().getColumn(5);
		column6.setPreferredWidth(60);
		// bdays
		TableColumn column7 = table.getColumnModel().getColumn(6);
		column7.setPreferredWidth(35);
		// bholdtime
		TableColumn column8 = table.getColumnModel().getColumn(7);
		column8.setPreferredWidth(150);
		// bmoney
		TableColumn column9 = table.getColumnModel().getColumn(8);
		column9.setPreferredWidth(50);
		// bPS
		TableColumn column10 = table.getColumnModel().getColumn(9);
		column10.setPreferredWidth(60);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setBounds(10, 43, 574, 257);
		book.getContentPane().add(table);
		// 表格渲染器，使文字居中
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);

		JScrollPane scrollPane = new JScrollPane(table);// 可滚动
		table.setFillsViewportHeight(true);
		scrollPane.setBounds(0, 43, 594, 257);
		book.getContentPane().add(scrollPane);

		// 选中索引行
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow(); // 获得选中行索引
				Object oid = tableModel.getValueAt(selectedRow, 0);
				Object oname = tableModel.getValueAt(selectedRow, 1);
				Object osex = tableModel.getValueAt(selectedRow, 2);
				Object opnum = tableModel.getValueAt(selectedRow, 3);
				Object oidcard = tableModel.getValueAt(selectedRow, 4);
				Object ornum = tableModel.getValueAt(selectedRow, 5);
				Object oday = tableModel.getValueAt(selectedRow, 6);
				Object oholdtime = tableModel.getValueAt(selectedRow, 7);
				Object omoney = tableModel.getValueAt(selectedRow, 8);
				Object ops = tableModel.getValueAt(selectedRow, 9);
				id = oid.toString();
				name = oname.toString();
				sex = osex.toString();
				pnum = opnum.toString();
				idcard = oidcard.toString();
				rnum = ornum.toString();
				day = oday.toString();
				money = omoney.toString();
				ps = ops.toString();
				SimpleDateFormat format = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				try {
					oldDate = format.parse(oholdtime.toString());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton exit = new JButton("取消");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				book.dispose();
			}
		});
		exit.setBounds(464, 325, 93, 23);
		book.getContentPane().add(exit);

		JButton btnNewButton = new JButton("入住");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(book, "请选择客户。");
				} else {
					int res = JOptionPane.showConfirmDialog(book, "该客户确认入住？");
					if (res == JOptionPane.YES_OPTION) {
						book.dispose();
						new BookCheckin(id, name, sex, pnum, idcard, rnum, day,
								money, ps);
					}
				}
			}
		});
		btnNewButton.setBounds(171, 325, 93, 23);
		book.getContentPane().add(btnNewButton);

		JButton button = new JButton("删除过期预定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(book, "请选择想要删除的过期预定信息。");
				} else {
					Date now = Calendar.getInstance().getTime();
					if (now.before(oldDate)) {
						JOptionPane.showMessageDialog(book, "该预定信息未超过预留时间！");
					} else {
						int res = JOptionPane.showConfirmDialog(book,
								"确定删除该条过期预定信息？");
						if (res == JOptionPane.YES_OPTION) {
							data_book.deleteBookCheckin(rnum);
							data_book.changeRstate_rnume(rnum);
							book.dispose();
						}
					}
				}

			}
		});
		button.setBounds(295, 325, 126, 23);
		book.getContentPane().add(button);

		// 预定******************************************************8
		Calendar ca = Calendar.getInstance();
		int year, month, day, hour, minute, second;
		year = ca.get(Calendar.YEAR);// 获取年份
		month = ca.get(Calendar.MONTH);// 获取月份
		day = ca.get(Calendar.DATE);// 获取日
		minute = ca.get(Calendar.MINUTE);// 分
		hour = ca.get(Calendar.HOUR);// 小时
		second = ca.get(Calendar.SECOND);// 秒
		final String cki = "" + year + month + day + hour + minute + second;
		JButton ruzhuButton = new JButton("预定");
		ruzhuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Checkin2(cki);
			}
		});
		ruzhuButton.setToolTipText("入住登记");
		ruzhuButton.setBounds(51, 325, 93, 23);
		book.getContentPane().add(ruzhuButton);
		// 结束***********************************************************8

		JLabel labelBook = new JLabel("背景图片");
		labelBook.setIcon(new ImageIcon(Book.class
				.getResource("/pictures/book.jpg")));
		labelBook.setBounds(0, 0, 594, 372);
		book.getContentPane().add(labelBook);
		book.setResizable(false);
		book.setVisible(true);

	}

	public static void main(String[] args) {
		new Book();
	}
}
