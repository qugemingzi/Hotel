package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import server.Database;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.ImageIcon;

public class Vipmember {

	// ��ʾ����ĵ�ǰ��Ա
	private JFrame jf;
	private Database data_vipmember;
	String[] columnNames;
	String[][] vipdata;
	private DefaultTableModel tableModel; // ���ģ�Ͷ���
	private JTable table;
	int vip_num;

	public Vipmember() {
		data_vipmember = new Database();
		jf = new JFrame("�����Ա��Ϣ");
		jf.setAlwaysOnTop(true);
		jf.setSize(new Dimension(700, 500));
		jf.setLocation(new Point(300, 150));
		jf.setResizable(false);
		jf.getContentPane().setLayout(null);
		vip_num = data_vipmember.getVipNum();

		JLabel label_vipnum = new JLabel("���깲�л�Ա��" + vip_num + "λ");
		label_vipnum.setForeground(Color.red);
		label_vipnum.setBounds(270, 66, 141, 15);
		jf.getContentPane().add(label_vipnum);

		columnNames = new String[] { "��Ա��", "����", "�Ա�", "���֤��", "�ֻ���", "�����ַ",
				"��Ա�ȼ�", "����", "������" };
		vipdata = data_vipmember.vipData();
		tableModel = new DefaultTableModel(vipdata, columnNames);
		table = new JTable(tableModel);
		table.setForeground(new Color(0, 0, 255));
		table.setGridColor(new Color(233, 150, 122));

		// ���ø��еĿ�ȣ��������ܽϺõĳ���
		// vid
		TableColumn column1 = table.getColumnModel().getColumn(0);
		column1.setPreferredWidth(50);
		// vname
		TableColumn column2 = table.getColumnModel().getColumn(1);
		column2.setPreferredWidth(60);
		// vsex
		TableColumn column3 = table.getColumnModel().getColumn(2);
		column3.setPreferredWidth(33);
		// vidcard
		TableColumn column4 = table.getColumnModel().getColumn(3);
		column4.setPreferredWidth(170);
		// vpnum
		TableColumn column5 = table.getColumnModel().getColumn(4);
		column5.setPreferredWidth(110);
		// brnum
		TableColumn column6 = table.getColumnModel().getColumn(5);
		column6.setPreferredWidth(130);
		// bdays
		TableColumn column7 = table.getColumnModel().getColumn(6);
		column7.setPreferredWidth(60);
		// bholdtime
		TableColumn column8 = table.getColumnModel().getColumn(7);
		column8.setPreferredWidth(60);
		// bmoney
		TableColumn column9 = table.getColumnModel().getColumn(8);
		column9.setPreferredWidth(50);

		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setBounds(10, 43, 674, 266);
		jf.getContentPane().add(table);
		// �����Ⱦ����ʹ���־���
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);

		JScrollPane scrollPane = new JScrollPane(table);// �ɹ���
		table.setFillsViewportHeight(true);
		scrollPane.setBounds(10, 102, 674, 261);
		jf.getContentPane().add(scrollPane);

		JLabel label_background = new JLabel("����ͼƬ");
		label_background.setIcon(new ImageIcon(Vipmember.class
				.getResource("/pictures/vipmenber.jpg")));
		label_background.setBounds(0, 0, 694, 472);
		jf.getContentPane().add(label_background);
		jf.setVisible(true);
	}

	public static void main(String[] args) {
		new Vipmember();
	}
}
