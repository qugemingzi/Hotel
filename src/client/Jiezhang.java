package client;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import server.Database;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.ImageIcon;

public class Jiezhang {

	private Database data_jiezhang;
	private String str_rnum;
	private int jff;
	private JFrame jf5;
	private JTextField rnum;
	private JTextField id;
	private JTextField name;
	private JTextField pnum;
	private JTextField money;
	private JTextField checkin;
	private JTextField day;
	private JTextField cash;
	private JTextField remain;
	private JTextField checkout;
	private JTextField jifen;
	private JTextField clevel;
	private JTextField roomcost;

	public Jiezhang() {
		data_jiezhang = new Database();
		jf5 = new JFrame("结账");
		jf5.setSize(new Dimension(500, 400));
		jf5.setLocation(new Point(300, 150));
		jf5.getContentPane().setLayout(null);

		JLabel label_rnum = new JLabel("请输入房间号：");
		label_rnum.setBounds(10, 24, 91, 35);
		jf5.getContentPane().add(label_rnum);

		rnum = new JTextField();
		rnum.setBounds(99, 31, 66, 21);
		jf5.getContentPane().add(rnum);
		rnum.setColumns(10);

		JLabel label_roomcost = new JLabel("客房消費：");
		label_roomcost.setBounds(200, 24, 91, 35);
		jf5.getContentPane().add(label_roomcost);

		roomcost = new JTextField();
		roomcost.setBounds(265, 31, 66, 21);
		jf5.getContentPane().add(roomcost);
		roomcost.setColumns(10);

		JLabel label_id = new JLabel("登记ID：");
		label_id.setBounds(46, 102, 54, 15);
		jf5.getContentPane().add(label_id);

		id = new JTextField();
		id.setBounds(99, 99, 91, 21);
		jf5.getContentPane().add(id);
		id.setColumns(10);

		JLabel label_name = new JLabel("姓名：");
		label_name.setBounds(200, 102, 54, 15);
		jf5.getContentPane().add(label_name);

		name = new JTextField();
		name.setBounds(239, 99, 66, 21);
		jf5.getContentPane().add(name);
		name.setColumns(10);

		JLabel label_pnum = new JLabel("手机号：");
		label_pnum.setBounds(315, 102, 54, 15);
		jf5.getContentPane().add(label_pnum);

		pnum = new JTextField();
		pnum.setBounds(365, 99, 105, 21);
		jf5.getContentPane().add(pnum);
		pnum.setColumns(10);

		JLabel label_money = new JLabel("房费：");
		label_money.setBounds(46, 141, 54, 15);
		jf5.getContentPane().add(label_money);

		money = new JTextField();
		money.setBounds(99, 138, 66, 21);
		jf5.getContentPane().add(money);
		money.setColumns(10);

		JLabel label_checkin = new JLabel("入住时间：");
		label_checkin.setBounds(200, 183, 66, 15);
		jf5.getContentPane().add(label_checkin);

		checkin = new JTextField();
		checkin.setBounds(264, 180, 137, 21);
		jf5.getContentPane().add(checkin);
		checkin.setColumns(10);

		JLabel label_day = new JLabel("入住天数：");
		label_day.setBounds(200, 141, 66, 15);
		jf5.getContentPane().add(label_day);

		day = new JTextField();
		day.setBounds(264, 138, 41, 21);
		jf5.getContentPane().add(day);
		day.setColumns(10);

		JLabel label_cash = new JLabel("押金：");
		label_cash.setBounds(46, 183, 54, 15);
		jf5.getContentPane().add(label_cash);

		cash = new JTextField();
		cash.setBounds(99, 180, 66, 21);
		jf5.getContentPane().add(cash);
		cash.setColumns(10);

		JLabel label_remain = new JLabel("卡内余额：");
		label_remain.setBounds(46, 237, 66, 15);
		jf5.getContentPane().add(label_remain);

		remain = new JTextField();
		remain.setBounds(110, 234, 66, 21);
		jf5.getContentPane().add(remain);
		remain.setColumns(10);

		JLabel label_jifen = new JLabel("生成积分：");
		label_jifen.setBounds(200, 269, 66, 15);
		jf5.getContentPane().add(label_jifen);

		jifen = new JTextField();
		jifen.setBounds(264, 266, 80, 21);
		jf5.getContentPane().add(jifen);
		jifen.setColumns(10);

		JLabel label_clevel = new JLabel("会员等级：");
		label_clevel.setBounds(46, 269, 66, 15);
		jf5.getContentPane().add(label_clevel);

		clevel = new JTextField();
		clevel.setBounds(110, 266, 66, 21);
		jf5.getContentPane().add(clevel);
		clevel.setColumns(10);

		JButton button = new JButton("显示入住信息");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				str_rnum = rnum.getText();
				if (data_jiezhang.cMeiruzhu(str_rnum)) {
					JOptionPane.showMessageDialog(null, "该房间号未入住！");
					return;
				}
				id.setText(data_jiezhang.cId(str_rnum));
				name.setText(data_jiezhang.cName(str_rnum));
				pnum.setText(data_jiezhang.cPnum(str_rnum));
				money.setText(data_jiezhang.cMoney(str_rnum));
				checkin.setText(data_jiezhang.cCheckin(str_rnum));
				cash.setText(data_jiezhang.cCash(str_rnum) + "元");
				day.setText(data_jiezhang.cDay(str_rnum) + "天");
				clevel.setText(data_jiezhang.stringVipLevel(name.getText()));
				// 卡内余额 即为应当返还的押金
				if (data_jiezhang.cPs(str_rnum).equals("积分换房")) {
					cash.setText("无需押金");
					remain.setText("0元");
					jifen.setText("不产生积分");
					jff = 0;
				} else {
					int e = Integer.parseInt(data_jiezhang.cCash(str_rnum));
					int r = Integer
							.parseInt(data_jiezhang.cMoney(str_rnum)
									.substring(
											0,
											data_jiezhang.cMoney(str_rnum)
													.length() - 1));
					int cost = 0;
					if (roomcost.getText() != "") {
						cost = Integer.parseInt(roomcost.getText());
					}
					remain.setText(e - r - cost + "元");
					// 产生积分
					System.out.println(data_jiezhang.vipLevel(name.getText()));
					jff = (r + cost) * data_jiezhang.vipLevel(name.getText());
					if (jff == 0) {
						jifen.setText("该客户非会员");
					} else {
						jifen.setText(jff + "分");
					}
				}

			}
		});
		button.setBounds(99, 62, 115, 23);
		jf5.getContentPane().add(button);

		JLabel label_checkout = new JLabel("退房时间：");
		label_checkout.setBounds(200, 237, 66, 15);
		jf5.getContentPane().add(label_checkout);

		checkout = new JTextField();
		checkout.setBounds(264, 234, 137, 21);
		jf5.getContentPane().add(checkout);
		this.setTimer(checkout);
		checkout.setColumns(10);

		JButton jiezhang = new JButton("确定结账");
		jiezhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (data_jiezhang.cMeiruzhu(str_rnum)) {
					JOptionPane.showMessageDialog(null, "信息出错，请检查信息！");
				} else {

					if (data_jiezhang.checkOut(str_rnum, checkout.getText())
							&& data_jiezhang.checkOutOrNot(str_rnum)
							&& data_jiezhang.changeRstate_rnume(str_rnum)
							&& data_jiezhang.jiaFangWan(name.getText())
							&& data_jiezhang.jiaJiFen(name.getText(), jff)) {
						JOptionPane.showMessageDialog(null, "成功结账！");
						jf5.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "信息出错，请检查信息！");
					}
				}
			}
		});
		jiezhang.setBounds(110, 309, 93, 23);
		jf5.getContentPane().add(jiezhang);

		JButton exit = new JButton("取消");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int res = JOptionPane.showConfirmDialog(null, "确定现在不结账？");
				if (res == JOptionPane.YES_OPTION) {
					jf5.dispose();
				}
			}
		});
		exit.setBounds(264, 309, 93, 23);
		jf5.getContentPane().add(exit);

		JLabel jiezhangframe = new JLabel("New label");
		jiezhangframe.setIcon(new ImageIcon(Jiezhang.class
				.getResource("/pictures/jiezhang.jpg")));
		jiezhangframe.setBounds(0, 0, 494, 372);
		jf5.getContentPane().add(jiezhangframe);

		jf5.setResizable(false);
		jf5.setVisible(true);
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
		new Jiezhang();
	}
}
