package client;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import server.Database;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Addvip {

	/**
	 * 办理会员 黄金会员30元，白金会员200元
	 */
	private Database data_addvip;
	private JFrame jf;
	String id, name, sex, idcard, pnum, mailbox, level;
	private JTextField vid;
	private JTextField vname;
	JRadioButton male, female;
	private JTextField vidcard;
	private JTextField vpnum;
	private JTextField vmailbox;
	private JTextField money;
	JRadioButton gold, platinum, diamond;
	private JButton confirm;
	private JButton concel;

	// 添加会员界面
	public Addvip() {
		data_addvip = new Database();
		jf = new JFrame();
		jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				int res = JOptionPane.showConfirmDialog(null, "确定取消办理会员？");
				if (res == JOptionPane.YES_OPTION) {
					jf.dispose();
				}
			}
		});
		jf.setSize(new Dimension(500, 375));
		jf.setLocation(new Point(300, 150));
		jf.setTitle("办理会员");
		jf.getContentPane().setLayout(null);

		JLabel label_vid = new JLabel("会员ID：");
		label_vid.setForeground(Color.yellow);
		label_vid.setBounds(23, 40, 54, 15);
		jf.getContentPane().add(label_vid);

		// 获取数据库中最后一名会员的ID，+1后填入会员办理
		vid = new JTextField();
		vid.setText((Integer.parseInt(data_addvip.vipLastId()) + 1) + "");
		vid.setBounds(71, 37, 66, 21);
		jf.getContentPane().add(vid);
		vid.setColumns(10);

		JLabel label_vname = new JLabel("姓名：");
		label_vname.setForeground(Color.yellow);
		label_vname.setBounds(23, 93, 54, 15);
		jf.getContentPane().add(label_vname);

		vname = new JTextField();
		vname.setBounds(71, 90, 66, 21);
		jf.getContentPane().add(vname);
		vname.setColumns(10);

		JLabel label_vsex = new JLabel("性别：");
		label_vsex.setForeground(Color.yellow);
		label_vsex.setBounds(179, 93, 54, 15);
		jf.getContentPane().add(label_vsex);

		ButtonGroup groupsex = new ButtonGroup();
		male = new JRadioButton("男");
		male.setBounds(222, 89, 46, 23);
		jf.getContentPane().add(male);
		female = new JRadioButton("女");
		female.setBounds(275, 89, 46, 23);
		jf.getContentPane().add(female);
		groupsex.add(male);
		groupsex.add(female);

		JLabel label_vpnum = new JLabel("手机号：");
		label_vpnum.setForeground(Color.RED);
		label_vpnum.setBounds(23, 137, 54, 15);
		jf.getContentPane().add(label_vpnum);

		vpnum = new JTextField();
		vpnum.setBounds(71, 134, 98, 21);
		jf.getContentPane().add(vpnum);
		vpnum.setColumns(10);

		JLabel label_vidcard = new JLabel("身份证号");
		label_vidcard.setForeground(Color.red);
		label_vidcard.setBounds(179, 137, 66, 15);
		jf.getContentPane().add(label_vidcard);

		vidcard = new JTextField();
		vidcard.setBounds(235, 134, 138, 21);
		jf.getContentPane().add(vidcard);
		vidcard.setColumns(10);

		JLabel label_vmailbox = new JLabel("邮箱：");
		label_vmailbox.setForeground(Color.yellow);
		label_vmailbox.setBounds(23, 182, 54, 15);
		jf.getContentPane().add(label_vmailbox);

		vmailbox = new JTextField();
		vmailbox.setBounds(71, 179, 110, 21);
		jf.getContentPane().add(vmailbox);
		vmailbox.setColumns(10);

		JLabel label_addvip = new JLabel("办理会员：");
		label_addvip.setForeground(Color.orange);
		label_addvip.setBounds(49, 223, 66, 15);
		jf.getContentPane().add(label_addvip);

		ButtonGroup vipgroup = new ButtonGroup();
		gold = new JRadioButton("黄金会员");
		gold.setBounds(124, 219, 83, 23);
		jf.getContentPane().add(gold);

		platinum = new JRadioButton("白金会员");
		platinum.setBounds(209, 219, 83, 23);
		jf.getContentPane().add(platinum);

		diamond = new JRadioButton("钻石会员");
		diamond.setBounds(294, 219, 83, 23);
		jf.getContentPane().add(diamond);
		vipgroup.add(gold);
		vipgroup.add(platinum);
		vipgroup.add(diamond);

		money = new JTextField();
		money.setBounds(209, 249, 66, 21);
		jf.getContentPane().add(money);
		money.setColumns(10);

		JButton button = new JButton("应交纳金额：");
		button.setBounds(71, 248, 114, 23);
		jf.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (gold.isSelected()) {
					money.setText("30元");
					level = "黄金会员";
				} else if (platinum.isSelected()) {
					money.setText("200元");
					level = "白金会员";
				} else if (diamond.isSelected()) {
					money.setText("400元");
					level = "钻石会员";
				}
			}
		});

		confirm = new JButton("办理");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (female.isSelected()) {
					sex = "女";
				} else {
					sex = "男";
				}
				id = vid.getText();
				name = vname.getText();
				idcard = vidcard.getText();
				pnum = vpnum.getText();
				mailbox = vmailbox.getText();
				if (data_addvip.vipCheckin(id, name, sex, idcard, pnum,
						mailbox, level)) {
					System.out.println(level);
					JOptionPane.showMessageDialog(null, "会员办理成功！");
					jf.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "会员办理失败，请检查登记信息！");
				}
			}
		});
		confirm.setBounds(114, 292, 93, 23);
		jf.getContentPane().add(confirm);

		concel = new JButton("取消");
		concel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int res = JOptionPane.showConfirmDialog(null, "确定退出办理会员？");
				if (res == JOptionPane.YES_OPTION) {
					jf.dispose();
				}
			}
		});
		concel.setBounds(263, 292, 93, 23);
		jf.getContentPane().add(concel);

		JLabel label_tip = new JLabel("提示：");
		label_tip.setForeground(Color.ORANGE);
		label_tip.setBounds(195, 23, 54, 15);
		jf.getContentPane().add(label_tip);

		JLabel label_tip1 = new JLabel("黄金会员缴纳现金30元，白金会员缴纳现金200元，");
		label_tip1.setForeground(Color.ORANGE);
		label_tip1.setBounds(195, 48, 300, 15);
		jf.getContentPane().add(label_tip1);

		JLabel label_tip2 = new JLabel("钻石会员缴纳现金400元。");
		label_tip2.setForeground(Color.ORANGE);
		label_tip2.setBounds(195, 68, 178, 15);
		jf.getContentPane().add(label_tip2);

		JLabel label_background = new JLabel("背景图片");
		label_background.setIcon(new ImageIcon(Addvip.class
				.getResource("/pictures/addvip.jpg")));
		label_background.setBounds(0, 0, 484, 337);
		jf.getContentPane().add(label_background);

		jf.setVisible(true);
	}

	public static void main(String[] args) {
		new Addvip();
	}
}
