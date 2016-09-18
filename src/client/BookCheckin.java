package client;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

import server.Database;
import java.awt.Color;

public class BookCheckin {
	/**
	 * Ԥ����ס
	 */

	private Database data_bookcheckin;
	String id, name, sex, pnum, idcard, rnum, day, money, checkin, cash, ps,
			level;
	private JFrame jf;
	private JLabel label_id;
	private JTextField cid;
	private JLabel label_name;
	private JTextField cname;
	private JLabel label_sex;
	private JTextField csex;
	private JLabel label_pnum;
	private JTextField cpnum;
	private JLabel label_idcard;
	private JTextField cidcard;
	private JLabel label_rnum;
	private JTextField crnum;
	private JLabel label_day;
	private JTextField cday;
	private JLabel label_money;
	private JTextField cmoney;
	private JLabel label_cash;
	private JTextField ccash;
	private JLabel label_checkin;
	private JTextField ccheckin;
	private JLabel label_ps;
	private JTextField cps;
	private JButton confirm;
	private JButton exit;
	private JLabel lblNewLabel_1;

	// ԤԼ��ס����
	public BookCheckin(final String sid, final String sname, final String ssex,
			final String spnum, final String sidcard, final String srnum,
			final String sday, final String smoney, final String sps) {
		jf = new JFrame("��ס");
		data_bookcheckin = new Database();
		jf.setSize(new Dimension(450, 300));
		jf.setLocation(new Point(300, 150));
		jf.setResizable(false);
		jf.getContentPane().setLayout(null);

		label_id = new JLabel("��סID��");
		label_id.setForeground(Color.orange);
		label_id.setBounds(10, 50, 54, 15);
		jf.getContentPane().add(label_id);

		cid = new JTextField();
		cid.setText(sid);
		cid.setBounds(59, 47, 66, 21);
		jf.getContentPane().add(cid);
		cid.setColumns(10);

		label_name = new JLabel("������");
		label_name.setForeground(Color.orange);
		label_name.setBounds(149, 50, 54, 15);
		jf.getContentPane().add(label_name);

		cname = new JTextField();
		cname.setText(sname);
		cname.setBounds(191, 47, 66, 21);
		jf.getContentPane().add(cname);
		cname.setColumns(10);

		label_sex = new JLabel("�Ա�");
		label_sex.setForeground(Color.orange);
		label_sex.setBounds(267, 50, 54, 15);
		jf.getContentPane().add(label_sex);

		csex = new JTextField();
		csex.setText(ssex);
		csex.setBounds(305, 47, 35, 21);
		jf.getContentPane().add(csex);
		csex.setColumns(10);

		label_pnum = new JLabel("�ֻ��ţ�");
		label_pnum.setForeground(Color.orange);
		label_pnum.setBounds(10, 86, 54, 15);
		jf.getContentPane().add(label_pnum);

		cpnum = new JTextField();
		cpnum.setText(spnum);
		cpnum.setBounds(59, 83, 91, 21);
		jf.getContentPane().add(cpnum);
		cpnum.setColumns(10);

		label_idcard = new JLabel("���֤�ţ�");
		label_idcard.setForeground(Color.orange);
		label_idcard.setBounds(160, 86, 66, 15);
		jf.getContentPane().add(label_idcard);

		cidcard = new JTextField();
		cidcard.setText(sidcard);
		cidcard.setBounds(222, 83, 145, 21);
		jf.getContentPane().add(cidcard);
		cidcard.setColumns(10);

		label_rnum = new JLabel("����ţ�");
		label_rnum.setForeground(Color.orange);
		label_rnum.setBounds(10, 121, 54, 15);
		jf.getContentPane().add(label_rnum);

		crnum = new JTextField();
		crnum.setText(srnum);
		crnum.setBounds(59, 118, 49, 21);
		jf.getContentPane().add(crnum);
		crnum.setColumns(10);

		label_day = new JLabel("��ס������");
		label_day.setForeground(Color.orange);
		label_day.setBounds(118, 121, 66, 15);
		jf.getContentPane().add(label_day);

		cday = new JTextField();
		cday.setText(sday);
		cday.setBounds(180, 118, 49, 21);
		jf.getContentPane().add(cday);
		cday.setColumns(10);

		label_money = new JLabel("�����ѽ�");
		label_money.setForeground(Color.orange);
		label_money.setBounds(242, 121, 84, 15);
		jf.getContentPane().add(label_money);

		cmoney = new JTextField();
		cmoney.setText(smoney);
		cmoney.setBounds(319, 118, 48, 21);
		jf.getContentPane().add(cmoney);
		cmoney.setColumns(10);

		label_cash = new JLabel("Ѻ��");
		label_cash.setForeground(Color.orange);
		label_cash.setBounds(26, 174, 54, 15);
		jf.getContentPane().add(label_cash);

		ccash = new JTextField();
		if (sps.equals("���ֻ���")) {
			ccash.setText("����Ѻ��");
		}
		ccash.setBounds(59, 171, 49, 21);
		jf.getContentPane().add(ccash);
		ccash.setColumns(10);

		label_checkin = new JLabel("��סʱ�䣺");
		label_checkin.setForeground(Color.orange);
		label_checkin.setBounds(26, 217, 66, 15);
		jf.getContentPane().add(label_checkin);

		ccheckin = new JTextField();
		ccheckin.setBounds(83, 214, 120, 21);
		jf.getContentPane().add(ccheckin);
		this.setTimer(ccheckin);
		ccheckin.setColumns(10);

		label_ps = new JLabel("��ע��");
		label_ps.setForeground(Color.orange);
		label_ps.setBounds(149, 177, 54, 15);
		jf.getContentPane().add(label_ps);

		cps = new JTextField();
		cps.setText(sps);
		cps.setBounds(191, 171, 66, 21);
		jf.getContentPane().add(cps);
		cps.setColumns(10);

		confirm = new JButton("ȷ��");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id = sid;
				name = sname;
				sex = ssex;
				pnum = spnum;
				idcard = sidcard;
				rnum = srnum;
				money = smoney;
				day = sday;
				cash = ccash.getText();
				checkin = ccheckin.getText();
				ps = sps;
				level = data_bookcheckin.stringVipLevel(name);

				if (cash.equals("")) {
					JOptionPane.showMessageDialog(null, "������Ѻ��");
				} else {
					if (data_bookcheckin.Checkin(id, name, sex, pnum, idcard,
							rnum, money, checkin, day, cash, ps, level)) {
						JOptionPane.showMessageDialog(null, "��ס�ɹ���");
						jf.dispose();
						// ɾ����Ԥ�����е�����
						if (ps.equals("���ֻ���")) {
							data_bookcheckin.jianQuJiFen(
									name,
									Integer.parseInt(money.substring(0,
											money.length() - 1)));
						}
						data_bookcheckin.deleteBookCheckin(srnum);
						data_bookcheckin.Updaterstate_checkin();
					} else {
						JOptionPane.showMessageDialog(null, "��סʧ�ܣ�����������Ϣ��");
					}
				}
			}
		});
		confirm.setBounds(292, 170, 93, 23);
		jf.getContentPane().add(confirm);

		exit = new JButton("�˳�");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int res = JOptionPane.showConfirmDialog(null, "�ÿͻ�ȷ������ס��");
				if (res == JOptionPane.YES_OPTION) {
					jf.dispose();
				}
			}
		});
		exit.setBounds(292, 213, 93, 23);
		jf.getContentPane().add(exit);

		lblNewLabel_1 = new JLabel("����ͼƬ");
		lblNewLabel_1.setIcon(new ImageIcon(BookCheckin.class
				.getResource("/pictures/bookcheckin.jpg")));
		lblNewLabel_1.setBounds(0, 0, 444, 272);
		jf.getContentPane().add(lblNewLabel_1);
		jf.setVisible(true);

	}

	// ����Timer 1000msʵ��һ�ζ��� ʵ����һ���߳�
	private void setTimer(JTextField time) {
		final JTextField varTime = time;
		Timer timeAction = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				long timemillis = System.currentTimeMillis();
				// ת��������ʾ��ʽ
				SimpleDateFormat df = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				varTime.setText(df.format(new Date(timemillis)));
			}
		});
		timeAction.start();
	}

	public static void main(String[] args) {
		//new BookCheckin(" ", " ", " ", " ", " ", " ", " ", " ", " ");
	}
}
