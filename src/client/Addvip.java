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
	 * �����Ա �ƽ��Ա30Ԫ���׽��Ա200Ԫ
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

	// ��ӻ�Ա����
	public Addvip() {
		data_addvip = new Database();
		jf = new JFrame();
		jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				int res = JOptionPane.showConfirmDialog(null, "ȷ��ȡ�������Ա��");
				if (res == JOptionPane.YES_OPTION) {
					jf.dispose();
				}
			}
		});
		jf.setSize(new Dimension(500, 375));
		jf.setLocation(new Point(300, 150));
		jf.setTitle("�����Ա");
		jf.getContentPane().setLayout(null);

		JLabel label_vid = new JLabel("��ԱID��");
		label_vid.setForeground(Color.yellow);
		label_vid.setBounds(23, 40, 54, 15);
		jf.getContentPane().add(label_vid);

		// ��ȡ���ݿ������һ����Ա��ID��+1�������Ա����
		vid = new JTextField();
		vid.setText((Integer.parseInt(data_addvip.vipLastId()) + 1) + "");
		vid.setBounds(71, 37, 66, 21);
		jf.getContentPane().add(vid);
		vid.setColumns(10);

		JLabel label_vname = new JLabel("������");
		label_vname.setForeground(Color.yellow);
		label_vname.setBounds(23, 93, 54, 15);
		jf.getContentPane().add(label_vname);

		vname = new JTextField();
		vname.setBounds(71, 90, 66, 21);
		jf.getContentPane().add(vname);
		vname.setColumns(10);

		JLabel label_vsex = new JLabel("�Ա�");
		label_vsex.setForeground(Color.yellow);
		label_vsex.setBounds(179, 93, 54, 15);
		jf.getContentPane().add(label_vsex);

		ButtonGroup groupsex = new ButtonGroup();
		male = new JRadioButton("��");
		male.setBounds(222, 89, 46, 23);
		jf.getContentPane().add(male);
		female = new JRadioButton("Ů");
		female.setBounds(275, 89, 46, 23);
		jf.getContentPane().add(female);
		groupsex.add(male);
		groupsex.add(female);

		JLabel label_vpnum = new JLabel("�ֻ��ţ�");
		label_vpnum.setForeground(Color.RED);
		label_vpnum.setBounds(23, 137, 54, 15);
		jf.getContentPane().add(label_vpnum);

		vpnum = new JTextField();
		vpnum.setBounds(71, 134, 98, 21);
		jf.getContentPane().add(vpnum);
		vpnum.setColumns(10);

		JLabel label_vidcard = new JLabel("���֤��");
		label_vidcard.setForeground(Color.red);
		label_vidcard.setBounds(179, 137, 66, 15);
		jf.getContentPane().add(label_vidcard);

		vidcard = new JTextField();
		vidcard.setBounds(235, 134, 138, 21);
		jf.getContentPane().add(vidcard);
		vidcard.setColumns(10);

		JLabel label_vmailbox = new JLabel("���䣺");
		label_vmailbox.setForeground(Color.yellow);
		label_vmailbox.setBounds(23, 182, 54, 15);
		jf.getContentPane().add(label_vmailbox);

		vmailbox = new JTextField();
		vmailbox.setBounds(71, 179, 110, 21);
		jf.getContentPane().add(vmailbox);
		vmailbox.setColumns(10);

		JLabel label_addvip = new JLabel("�����Ա��");
		label_addvip.setForeground(Color.orange);
		label_addvip.setBounds(49, 223, 66, 15);
		jf.getContentPane().add(label_addvip);

		ButtonGroup vipgroup = new ButtonGroup();
		gold = new JRadioButton("�ƽ��Ա");
		gold.setBounds(124, 219, 83, 23);
		jf.getContentPane().add(gold);

		platinum = new JRadioButton("�׽��Ա");
		platinum.setBounds(209, 219, 83, 23);
		jf.getContentPane().add(platinum);

		diamond = new JRadioButton("��ʯ��Ա");
		diamond.setBounds(294, 219, 83, 23);
		jf.getContentPane().add(diamond);
		vipgroup.add(gold);
		vipgroup.add(platinum);
		vipgroup.add(diamond);

		money = new JTextField();
		money.setBounds(209, 249, 66, 21);
		jf.getContentPane().add(money);
		money.setColumns(10);

		JButton button = new JButton("Ӧ���ɽ�");
		button.setBounds(71, 248, 114, 23);
		jf.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (gold.isSelected()) {
					money.setText("30Ԫ");
					level = "�ƽ��Ա";
				} else if (platinum.isSelected()) {
					money.setText("200Ԫ");
					level = "�׽��Ա";
				} else if (diamond.isSelected()) {
					money.setText("400Ԫ");
					level = "��ʯ��Ա";
				}
			}
		});

		confirm = new JButton("����");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (female.isSelected()) {
					sex = "Ů";
				} else {
					sex = "��";
				}
				id = vid.getText();
				name = vname.getText();
				idcard = vidcard.getText();
				pnum = vpnum.getText();
				mailbox = vmailbox.getText();
				if (data_addvip.vipCheckin(id, name, sex, idcard, pnum,
						mailbox, level)) {
					System.out.println(level);
					JOptionPane.showMessageDialog(null, "��Ա����ɹ���");
					jf.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "��Ա����ʧ�ܣ�����Ǽ���Ϣ��");
				}
			}
		});
		confirm.setBounds(114, 292, 93, 23);
		jf.getContentPane().add(confirm);

		concel = new JButton("ȡ��");
		concel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int res = JOptionPane.showConfirmDialog(null, "ȷ���˳������Ա��");
				if (res == JOptionPane.YES_OPTION) {
					jf.dispose();
				}
			}
		});
		concel.setBounds(263, 292, 93, 23);
		jf.getContentPane().add(concel);

		JLabel label_tip = new JLabel("��ʾ��");
		label_tip.setForeground(Color.ORANGE);
		label_tip.setBounds(195, 23, 54, 15);
		jf.getContentPane().add(label_tip);

		JLabel label_tip1 = new JLabel("�ƽ��Ա�����ֽ�30Ԫ���׽��Ա�����ֽ�200Ԫ��");
		label_tip1.setForeground(Color.ORANGE);
		label_tip1.setBounds(195, 48, 300, 15);
		jf.getContentPane().add(label_tip1);

		JLabel label_tip2 = new JLabel("��ʯ��Ա�����ֽ�400Ԫ��");
		label_tip2.setForeground(Color.ORANGE);
		label_tip2.setBounds(195, 68, 178, 15);
		jf.getContentPane().add(label_tip2);

		JLabel label_background = new JLabel("����ͼƬ");
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
