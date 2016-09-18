package client;

import javax.swing.JFrame;
import javax.swing.JTextField;

import server.Database;

import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class Checkin {
	private JFrame jf;
	Database data_checkin;
	// 要存入数据库中的数据
	String id, name, sex, pnum, idcard, rnum, money, checkin, checkout, day,
			cash, checkoutornot, ps;
	JTextField crnum;
	JTextField cday;
	JTextField crtype;
	JTextField crrate;
	JTextField crsize;
	JTextField crbednum;
	JTextField cname;
	JTextField cpnum;
	JTextField cidcard;
	JTextField cmoney;
	JTextField ccash;
	JTextField ctime;
	JTextField cps;
	JLabel label_rpic;
	JRadioButton female;
	JComboBox<String> cviplevel;
	String viplevel;

	// 客人入住
	public Checkin(final String ck) {
		data_checkin = new Database();

		jf = new JFrame();
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				jf.dispose();
			}
		});
		jf.setSize(new Dimension(600, 400));
		jf.setLocation(new Point(300, 150));
		jf.setTitle("客人登记");
		jf.getContentPane().setLayout(null);

		JLabel label_name = new JLabel("姓名：");
		label_name.setBounds(124, 47, 52, 28);
		jf.getContentPane().add(label_name);
		cname = new JTextField();

		cname.setBounds(168, 51, 66, 21);
		jf.getContentPane().add(cname);
		cname.setColumns(10);

		JLabel label_sex = new JLabel("性别：");
		label_sex.setBounds(262, 51, 52, 21);
		jf.getContentPane().add(label_sex);

		ButtonGroup groupsex = new ButtonGroup();
		JRadioButton male = new JRadioButton("男", true);
		male.setBounds(298, 50, 42, 23);
		jf.getContentPane().add(male);
		female = new JRadioButton("女", false);
		female.setBounds(342, 50, 42, 23);
		jf.getContentPane().add(female);
		groupsex.add(male);
		groupsex.add(female);

		JLabel label_pnum = new JLabel("手机号：");
		label_pnum.setBounds(390, 54, 54, 15);
		jf.getContentPane().add(label_pnum);

		cpnum = new JTextField();
		cpnum.setBounds(441, 51, 110, 21);
		jf.getContentPane().add(cpnum);
		cpnum.setColumns(10);

		JLabel label_idcard = new JLabel("身份证号：");
		label_idcard.setBounds(124, 95, 75, 28);
		jf.getContentPane().add(label_idcard);

		cidcard = new JTextField();
		cidcard.setBounds(201, 99, 154, 21);
		jf.getContentPane().add(cidcard);
		cidcard.setColumns(10);

		JLabel label_viplevel = new JLabel("会员等级：");
		label_viplevel.setBounds(390, 102, 66, 15);
		jf.getContentPane().add(label_viplevel);

		cviplevel = new JComboBox<String>();
		cviplevel.setEditable(false);
		cviplevel.addItem("非会员");
		cviplevel.addItem("黄金会员");
		cviplevel.addItem("白金会员");
		cviplevel.addItem("钻石会员");
		// 会员等级

		cviplevel.setBounds(451, 99, 100, 21);
		jf.getContentPane().add(cviplevel);

		JLabel label_rnum = new JLabel("房间号：");
		label_rnum.setBounds(124, 143, 54, 28);
		jf.getContentPane().add(label_rnum);

		crnum = new JTextField();
		// rnum中存有房间号的字符串
		crnum.setBounds(168, 147, 66, 21);
		jf.getContentPane().add(crnum);
		crnum.setColumns(10);

		JLabel label_rtype = new JLabel("房间类型：");
		label_rtype.setBounds(262, 150, 70, 15);
		jf.getContentPane().add(label_rtype);

		crtype = new JTextField();
		crtype.setEditable(false);
		crtype.setBounds(326, 147, 66, 21);
		jf.getContentPane().add(crtype);
		crtype.setColumns(10);
		label_rpic = new JLabel("房间图片");
		label_rpic.setBounds(10, 143, 100, 74);
		jf.getContentPane().add(label_rpic);

		JLabel label_rrate = new JLabel("房费：");
		label_rrate.setBounds(402, 150, 54, 15);
		jf.getContentPane().add(label_rrate);

		crrate = new JTextField();
		crrate.setEditable(false);
		crrate.setBounds(451, 147, 66, 21);
		jf.getContentPane().add(crrate);
		crrate.setColumns(10);

		JLabel label_rsize = new JLabel("房间面积：");
		label_rsize.setBounds(262, 198, 70, 15);
		jf.getContentPane().add(label_rsize);

		crsize = new JTextField();
		crsize.setEditable(false);
		crsize.setBounds(326, 196, 66, 21);
		jf.getContentPane().add(crsize);
		crsize.setColumns(10);

		JLabel label_rbednum = new JLabel("床数：");
		label_rbednum.setBounds(402, 198, 54, 15);
		jf.getContentPane().add(label_rbednum);

		crbednum = new JTextField();
		crbednum.setEditable(false);
		crbednum.setBounds(451, 196, 66, 21);
		jf.getContentPane().add(crbednum);
		crbednum.setColumns(10);

		JLabel label_money = new JLabel("总消费：");
		label_money.setBounds(262, 245, 54, 15);
		jf.getContentPane().add(label_money);

		cmoney = new JTextField();
		cmoney.setEditable(false);
		cmoney.setBounds(326, 242, 66, 21);
		jf.getContentPane().add(cmoney);
		cmoney.setColumns(10);

		JLabel label_day = new JLabel("入住天数：");
		label_day.setBounds(124, 198, 66, 15);
		jf.getContentPane().add(label_day);

		cday = new JTextField();
		cday.setBounds(186, 195, 48, 21);
		jf.getContentPane().add(cday);
		cday.setColumns(10);

		// ########################################################
		JLabel label_cash = new JLabel("押金：");
		label_cash.setBounds(402, 245, 54, 15);
		jf.getContentPane().add(label_cash);

		ccash = new JTextField();
		ccash.setBounds(451, 242, 42, 21);
		jf.getContentPane().add(ccash);
		ccash.setColumns(10);

		JButton rbutton = new JButton("显示相关信息");
		rbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rtype = data_checkin.rType(crnum.getText());
				// 判断输入的房号是否正确
				if (rtype == null) {
					JOptionPane.showMessageDialog(null, "房间号不正确！");
				} else if (data_checkin.rState(crnum.getText())) {
					JOptionPane.showMessageDialog(null, "该房间已被预定或入住！");
				} else if (cday.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "入住天数不能为空！");
				}

				label_rpic.setIcon(new ImageIcon(Checkin.class
						.getResource("/pictures/" + rtype + ".jpg")));
				crtype.setText(rtype);
				crrate.setText(data_checkin.rRate(crnum.getText()) + "元");
				crsize.setText(data_checkin.rSize(crnum.getText()) + "平方米");
				crbednum.setText(data_checkin.rBednum(crnum.getText()) + "张");
				name = cname.getText();
				pnum = cpnum.getText();
				idcard = cidcard.getText();
				rnum = crnum.getText();
				if (female.isSelected()) {
					sex = "女";
				} else {
					sex = "男";
				}
				viplevel = (String) cviplevel.getSelectedItem();
				day = cday.getText();
				int da = Integer.parseInt(day);
				int ra = data_checkin.rRate(crnum.getText());
				int m1 = ra * da;
				int m2 = (ra - 5) * da;
				int m3 = (ra - 10) * da;
				int m4 = (ra - 20) * da;
				switch (viplevel) {
				case "非会员":
					cmoney.setText(m1 + "元");
					break;
				case "黄金会员":
					cmoney.setText(m2 + "元");
					break;
				case "白金会员":
					cmoney.setText(m3 + "元");
					break;
				case "钻石会员":
					cmoney.setText(m4 + "元");
					break;
				}
				money = cmoney.getText();
			}
		});
		rbutton.setBounds(124, 241, 120, 23);
		jf.getContentPane().add(rbutton);

		JLabel label_yuan = new JLabel("元");
		label_yuan.setBounds(497, 245, 20, 15);
		jf.getContentPane().add(label_yuan);

		JLabel label_time = new JLabel("入住时间：");
		label_time.setBounds(124, 282, 75, 15);
		jf.getContentPane().add(label_time);

		ctime = new JTextField();
		ctime.setBounds(186, 279, 120, 21);
		jf.getContentPane().add(ctime);
		this.setTimer(ctime);
		ctime.setColumns(10);

		JLabel label_ps = new JLabel("备注：");
		label_ps.setBounds(326, 282, 54, 15);
		jf.getContentPane().add(label_ps);

		cps = new JTextField();
		cps.setBounds(369, 279, 66, 21);
		jf.getContentPane().add(cps);
		cps.setColumns(10);

		JButton checkinbutton = new JButton("确定");
		checkinbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name = cname.getText();
				pnum = cpnum.getText();
				idcard = cidcard.getText();
				rnum = crnum.getText();
				if (female.isSelected()) {
					sex = "女";
				} else {
					sex = "男";
				}
				id = ck;
				cash = ccash.getText();
				checkin = ctime.getText();
				ps = cps.getText();
				if (cash.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入押金");
				} else if (data_checkin.Checkin(id, name, sex, pnum, idcard,
						rnum, money, checkin, day, cash, ps, viplevel)) {
					JOptionPane.showMessageDialog(null, "登记成功！");
					jf.dispose();
					data_checkin.Updaterstate_checkin();
				} else {
					JOptionPane.showMessageDialog(null, "登记失败！请检查输入信息！");
				}
				System.out.println("name" + name + "sex" + sex + "pnum" + pnum
						+ "idcard" + idcard + "rnum" + rnum + viplevel
						+ "money" + money + "day" + day + "cash" + cash
						+ "checkin" + checkin + "ps" + ps);
			}
		});
		checkinbutton.setBounds(170, 324, 93, 23);
		jf.getContentPane().add(checkinbutton);

		JButton button_exit = new JButton("取消");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int res = JOptionPane.showConfirmDialog(null, "确定退出登记？");
				if (res == JOptionPane.YES_OPTION) {
					jf.dispose();
				}
			}
		});
		button_exit.setBounds(326, 324, 93, 23);
		jf.getContentPane().add(button_exit);

		// chekin的背景图片，声明的时候要放在构造方法的最后
		JLabel label_register = new JLabel("New label");
		label_register.setIcon(new ImageIcon(Checkin.class
				.getResource("/pictures/checkin.jpg")));
		label_register.setBounds(0, 0, 594, 372);
		jf.getContentPane().add(label_register);
		jf.setResizable(false);
		jf.setVisible(true);

	}

	// 设置Timer 1000ms实现一次动作 实际是一个线程
	private void setTimer(JTextField time) {
		final JTextField varTime = time;
		Timer timeAction = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				long timemillis = System.currentTimeMillis();
				// 转换日期显示格式
				SimpleDateFormat df = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				varTime.setText(df.format(new Date(timemillis)));
			}
		});
		timeAction.start();
	}

	public static void main(String[] args) {
		new Checkin("10001");
	}
}
