package client;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import server.Database;

public class Change {

	private Database data_change;
	private JFrame jf;
	String cid, rnume, rnumi, moneyi;
	private JTextField rnumed;
	private JTextField name;
	private JTextField money;
	private JTextField day;
	private JTextField rnuming;
	private JTextField crtype;
	private JTextField crrate;
	private JTextField crsize;
	private JTextField crbednum;
	private JTextField add;
	private JTextField moneying;
	private JTextField id;

	// ��������
	public Change() {
		data_change = new Database();
		jf = new JFrame("��������");
		jf.setSize(new Dimension(600, 400));
		jf.setLocation(new Point(300, 150));
		jf.getContentPane().setLayout(null);

		JLabel label_rnumed = new JLabel("��������Ҫ�����ķ���ţ�");
		label_rnumed.setBounds(28, 46, 158, 25);
		jf.getContentPane().add(label_rnumed);

		rnumed = new JTextField();
		rnumed.setBounds(184, 48, 66, 21);
		jf.getContentPane().add(rnumed);
		rnumed.setColumns(10);

		JLabel label_name = new JLabel("������");
		label_name.setBounds(180, 92, 45, 25);
		jf.getContentPane().add(label_name);

		name = new JTextField();
		name.setBounds(219, 94, 54, 21);
		jf.getContentPane().add(name);
		name.setColumns(10);

		JLabel label_id = new JLabel("�Ǽ�ID��");
		label_id.setBounds(28, 97, 66, 15);
		jf.getContentPane().add(label_id);

		id = new JTextField();
		id.setBounds(76, 94, 94, 21);
		jf.getContentPane().add(id);
		id.setColumns(10);

		JLabel label_money = new JLabel("�����ܼۣ�");
		label_money.setBounds(293, 97, 66, 15);
		jf.getContentPane().add(label_money);

		money = new JTextField();
		money.setBounds(356, 94, 45, 21);
		jf.getContentPane().add(money);
		money.setColumns(10);

		JLabel label_day = new JLabel("��ס������");
		label_day.setBounds(411, 97, 75, 15);
		jf.getContentPane().add(label_day);

		day = new JTextField();
		day.setBounds(473, 94, 35, 21);
		jf.getContentPane().add(day);
		day.setColumns(10);

		JButton button_logininfo = new JButton("��ʾ�Ǽ���Ϣ");
		button_logininfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rnume = rnumed.getText();
				cid = data_change.cId(rnume);
				if (data_change.cMeiruzhu(rnume)) {
					JOptionPane.showMessageDialog(null, "�÷����δ�Ǽǣ�");
				} else if (data_change.cPs(rnume).equals("���ֻ���")) {
					JOptionPane.showMessageDialog(null, "���ֶһ��ķ����޷�������");
				} else {
					name.setText(data_change.cName(rnume));
					id.setText(data_change.cId(rnume));
					money.setText(data_change.cMoney(rnume));
					day.setText(data_change.cDay(rnume) + "��");
				}
			}
		});
		button_logininfo.setBounds(273, 47, 144, 23);
		jf.getContentPane().add(button_logininfo);

		JLabel label_rnuming = new JLabel("��������Ҫ����ɷ���ţ�");
		label_rnuming.setBounds(28, 156, 158, 25);
		jf.getContentPane().add(label_rnuming);

		rnuming = new JTextField();
		rnuming.setBounds(184, 158, 66, 21);
		jf.getContentPane().add(rnuming);
		rnuming.setColumns(10);

		JLabel label_rtype = new JLabel("�������ͣ�");
		label_rtype.setBounds(28, 205, 66, 15);
		jf.getContentPane().add(label_rtype);

		crtype = new JTextField();
		crtype.setEditable(false);
		crtype.setBounds(91, 202, 66, 21);
		jf.getContentPane().add(crtype);
		crtype.setColumns(10);

		JLabel label_rrate = new JLabel("���ѣ�");
		label_rrate.setBounds(171, 205, 54, 15);
		jf.getContentPane().add(label_rrate);

		crrate = new JTextField();
		crrate.setEditable(false);
		crrate.setBounds(207, 202, 66, 21);
		jf.getContentPane().add(crrate);
		crrate.setColumns(10);

		JLabel label_rsize = new JLabel("���������");
		label_rsize.setBounds(293, 205, 66, 15);
		jf.getContentPane().add(label_rsize);

		crsize = new JTextField();
		crsize.setEditable(false);
		crsize.setBounds(356, 202, 66, 21);
		jf.getContentPane().add(crsize);
		crsize.setColumns(10);

		JLabel label_rbednum = new JLabel("������");
		label_rbednum.setBounds(432, 205, 54, 15);
		jf.getContentPane().add(label_rbednum);

		crbednum = new JTextField();
		crbednum.setEditable(false);
		crbednum.setBounds(462, 202, 66, 21);
		jf.getContentPane().add(crbednum);
		crbednum.setColumns(10);

		JLabel label_add = new JLabel("�������ѣ�");
		label_add.setBounds(28, 243, 77, 15);
		jf.getContentPane().add(label_add);

		add = new JTextField();
		add.setBounds(91, 240, 66, 21);
		jf.getContentPane().add(add);
		add.setColumns(10);

		JLabel label_moneying = new JLabel("�����ܼ۱��Ϊ��");
		label_moneying.setBounds(171, 243, 108, 15);
		jf.getContentPane().add(label_moneying);

		moneying = new JTextField();
		moneying.setBounds(273, 240, 66, 21);
		jf.getContentPane().add(moneying);
		moneying.setColumns(10);

		JButton button_roominfo = new JButton("��ʾ�÷�����Ϣ");
		button_roominfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rnumi = rnuming.getText();
				if (!data_change.cMeiruzhu(rnumi)) {
					JOptionPane.showMessageDialog(null, "�˷�������ס��");
					return;
				} else if (data_change.cYiyuding(rnumi)) {
					JOptionPane.showMessageDialog(null, "�˷����ѱ�Ԥ����");
					return;
				}
				crtype.setText(data_change.rType(rnumi));
				crrate.setText(data_change.rRate(rnumi) + "Ԫ");
				crsize.setText(data_change.rSize(rnumi) + "ƽ����");
				crbednum.setText(data_change.rBednum(rnumi) + "��");
				int a = data_change.rRate(rnume);
				int b = data_change.rRate(rnumi);
				int c = Integer.parseInt(data_change.cDay(rnume));
				int d = (b - a) * c;
				add.setText(d + "Ԫ");
				int e = Integer.parseInt(data_change.cMoney(rnume).substring(0,
						data_change.cMoney(rnume).length() - 1));
				moneying.setText(d + e + "Ԫ");
				// moneyi�д洢�����ķ��ѡ���cmoney
				moneyi = d + e + "";
			}
		});
		button_roominfo.setBounds(273, 157, 144, 23);
		jf.getContentPane().add(button_roominfo);

		JButton button_change = new JButton("ȷ��");
		button_change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rnumed.getText().equals("") || rnuming.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�����뻻����Ϣ");
				} else if (data_change.changeMoney(cid, moneyi)
						&& data_change.changeRnum(cid, rnumi)
						&& data_change.changeRstate_rnumi(rnumi)
						&& data_change.changeRstate_rnume(rnume)) {
					JOptionPane.showMessageDialog(null, "�����ɹ���");
					jf.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "����ʧ�ܣ�������Ϣ����");
				}
			}
		});
		button_change.setBounds(157, 299, 93, 23);
		jf.getContentPane().add(button_change);

		JButton exit = new JButton("ȡ��");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int res = JOptionPane.showConfirmDialog(null, "ȷ���˳�������");
				if (res == JOptionPane.YES_OPTION) {
					jf.dispose();
				}
			}
		});
		exit.setBounds(324, 299, 93, 23);
		jf.getContentPane().add(exit);

		JLabel labelChange = new JLabel("New label");
		labelChange.setIcon(new ImageIcon(Change.class
				.getResource("/pictures/change.jpg")));
		labelChange.setBounds(0, 0, 594, 372);
		jf.getContentPane().add(labelChange);

		jf.setResizable(false);
		jf.setVisible(true);
	}

	public static void main(String[] args) {
		new Change();
	}
}
