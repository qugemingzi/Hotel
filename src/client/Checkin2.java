package client;

import server.Database;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class Checkin2 {
	/**
	 * 预订
	 */
	private JFrame jf;
	Database data_checkin2;
	private JTextField cname;
	private JTextField cpnum;
	private JTextField cidcard;
	private JTextField crnum;
	private JTextField cmoney;
	private JTextField cday;
	private JTextField choldtime;
	private JTextField cps;
	private JRadioButton male, female;
	// 要存入数据库中的数据
	String bid, bname, bsex, bpnum, bidcard, brnum, bday,bholdtime,bsummoney,bps;
	Socket soc;
	
	//客人入住
	public Checkin2(final String ck) {
		data_checkin2 = new Database();

		jf = new JFrame();
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				jf.dispose();
			}
		});
		jf.setSize(new Dimension(600, 400));
		jf.setLocation(new Point(350, 200));
		jf.setTitle("客人预定");
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
		male = new JRadioButton("男", true);
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

		JLabel lable_idcard = new JLabel("身份证号：");
		lable_idcard.setBounds(124, 95, 75, 28);
		jf.getContentPane().add(lable_idcard);

		cidcard = new JTextField();
		cidcard.setBounds(201, 99, 154, 21);
		jf.getContentPane().add(cidcard);
		cidcard.setColumns(10);

		JLabel label_rnum = new JLabel("房间号：");
		label_rnum.setBounds(124, 143, 54, 28);
		jf.getContentPane().add(label_rnum);

		crnum = new JTextField();
		// rnum中存有房间号的字符串
		crnum.setBounds(168, 147, 66, 21);
		jf.getContentPane().add(crnum);
		crnum.setColumns(10);

		JLabel label_message = new JLabel("101，201，301，107，207，307房间200元一晚；");
		label_message.setForeground(Color.ORANGE);
		label_message.setBounds(295, 148, 300, 15);
		jf.getContentPane().add(label_message);
		
		label_message = new JLabel("102，103，104，202，203，204，");
		label_message.setForeground(Color.ORANGE);
		label_message.setBounds(295, 163, 300, 15);
		jf.getContentPane().add(label_message);
		
		label_message = new JLabel("302，303，304房间180元一晚；");
		label_message.setForeground(Color.ORANGE);
		label_message.setBounds(295, 178, 216, 15);
		jf.getContentPane().add(label_message);
		
		label_message = new JLabel("105，205，305，房间230元一晚；");
		label_message.setForeground(Color.ORANGE);
		label_message.setBounds(295, 193, 216, 15);
		jf.getContentPane().add(label_message);
		
		label_message = new JLabel("106，206，306，房间300元一晚；");
		label_message.setForeground(Color.ORANGE);
		label_message.setBounds(295, 208, 216, 15);
		jf.getContentPane().add(label_message);

		JLabel label_day = new JLabel("入住天数：");
		label_day.setBounds(124, 198, 66, 15);
		jf.getContentPane().add(label_day);

		cday = new JTextField();
		cday.setBounds(186, 195, 48, 21);
		jf.getContentPane().add(cday);
		cday.setColumns(10);

		JLabel label_money = new JLabel("总消费：");
		label_money.setBounds(124, 245, 54, 15);
		jf.getContentPane().add(label_money);
		
		cmoney = new JTextField();
		cmoney.setBounds(196, 242, 66, 21);
		jf.getContentPane().add(cmoney);
		cmoney.setColumns(10);

		JLabel label_holdtime = new JLabel("登记时间：");
		label_holdtime.setBounds(124, 282, 75, 15);
		jf.getContentPane().add(label_holdtime);

		choldtime = new JTextField();
		choldtime.setBounds(186, 279, 120, 21);
		jf.getContentPane().add(choldtime);
		this.setTimer(choldtime);
		choldtime.setColumns(10);

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
				bid = ck;
				bname = cname.getText();
				if (female.isSelected()) {
					bsex = "女";
				} else {
					bsex = "男";
				}
				bpnum = cpnum.getText();
				bidcard = cidcard.getText();
				brnum = crnum.getText();
				bday = cday.getText();
				bholdtime = choldtime.getText();
				bsummoney = cmoney.getText()+"元";
				bps = cps.getText();
				if (data_checkin2.yuding(bid, bname, bsex, bpnum, bidcard, brnum, bday,bholdtime,bsummoney, bps)) {
					JOptionPane.showMessageDialog(null, "预订成功！");
					jf.dispose();
					data_checkin2.Updaterstate_checkin();
				} else {
					JOptionPane.showMessageDialog(null, "预订失败！请检查输入信息！");
				}
				}
			});
		
		checkinbutton.setBounds(170, 324, 93, 23);
		jf.getContentPane().add(checkinbutton);

		JButton exitbutton = new JButton("取消");
		exitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int res = JOptionPane.showConfirmDialog(null, "确定退出登记？");
				if (res == JOptionPane.YES_OPTION) {
					jf.dispose();
				}
			}
		});
		exitbutton.setBounds(326, 324, 93, 23);
		jf.getContentPane().add(exitbutton);

		// chekin的背景图片，声明的时候要放在构造方法的最后
		JLabel label_register = new JLabel("New label");
		label_register.setIcon(new ImageIcon(Checkin2.class
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
		new Checkin2("10003");
	}
}
