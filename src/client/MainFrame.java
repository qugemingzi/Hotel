package client;

import server.Database;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

import javax.swing.*;

public class MainFrame  {
	private JFrame jf1;
	private Database data_mainframe;
	int year, month, day, hour, minute, second;


	public MainFrame(final String username) {
		data_mainframe = new Database();
		int x=0;
		
		//主界面
		jf1 = new JFrame("酒店管理系统");
		jf1.setTitle("酒店管理系统");
		jf1.setResizable(false);
		jf1.setSize(new Dimension(1000, 600));
		jf1.setLocation(new Point(200, 100));
		jf1.getContentPane().setLayout(null);
		jf1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jf1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				int res = JOptionPane.showConfirmDialog(null, "确定退出酒店管理系统？");
				if (res == JOptionPane.YES_OPTION) {
					jf1.dispose();
					System.exit(0);
					}
			}
		});

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 994, 26);
		jf1.getContentPane().add(menuBar);

		JMenu wenjian = new JMenu("文件");
		wenjian.setAlignmentX(Component.LEFT_ALIGNMENT);
		menuBar.add(wenjian);

		JMenuItem restart = new JMenuItem("重启系统");
		restart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				jf1.dispose();
				new MainFrame(username);
			}
		});
		wenjian.add(restart);

		JMenuItem exit = new JMenuItem("退出");
		exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "确定退出酒店管理系统？");
				if (res == JOptionPane.YES_OPTION) {
					jf1.dispose();
					System.exit(0);
					}
			}
		});
		
		wenjian.add(exit);

		JMenu help = new JMenu("帮助");
		menuBar.add(help);

		final JMenuItem usehelp = new JMenuItem("使用说明");
		usehelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(usehelp, "help");
			}
		});
		help.add(usehelp);
       

		Calendar ca = Calendar.getInstance();
		year = ca.get(Calendar.YEAR);// 获取年份
		month = ca.get(Calendar.MONTH);// 获取月份
		day = ca.get(Calendar.DATE);// 获取日
		minute = ca.get(Calendar.MINUTE);// 分
		hour = ca.get(Calendar.HOUR);// 小时
		second = ca.get(Calendar.SECOND);// 秒
		
		//歡迎
		JLabel label_welcome = new JLabel("welcome to " + username + " !");
		label_welcome.setBounds(x+15, 50, 600, 100);
		label_welcome.setFont(new Font("ITALIC",1,15));
		jf1.getContentPane().add(label_welcome);
		
		//预定
		JButton book = new JButton("预定");
		book.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/bookbutton.jpg")));
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Book();
			}
		});
		book.setToolTipText("预订信息");
		book.setBounds(x+15, 125, 87, 50);
		jf1.getContentPane().add(book);
		
        //登记入住
		JButton checkin = new JButton("登记");
		checkin.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/checkinbutton.jpg")));
		checkin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Checkin("" + year + month + day + hour + minute + second);
			}
		});
		checkin.setToolTipText("入住登记");
		checkin.setBounds(x+148, 125, 87, 50);
		jf1.getContentPane().add(checkin);
        //换房
		JButton huanfang = new JButton("换房");
		huanfang.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/changebu.png")));
		huanfang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Change();
			}
		});
		huanfang.setToolTipText("更换房间");
		huanfang.setBounds(x+281, 125, 87, 50);
		jf1.getContentPane().add(huanfang);
        
		//结账
		JButton jiezhang = new JButton("结账");
		jiezhang.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/jiezhangbutton.jpg")));
		jiezhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Jiezhang();
			}
		});
		jiezhang.setToolTipText("客户结账");
		jiezhang.setBounds(x+414, 125, 87, 50);
		jf1.getContentPane().add(jiezhang);

		//会员
		JButton vip = new JButton("会员");
		vip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Vip();
			}
		});
		vip.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/vipbutton.jpg")));
		vip.setToolTipText("会员制度");
		vip.setBounds(x+547, 125, 87, 50);
		jf1.getContentPane().add(vip);

		JLabel main1 = new JLabel("New label");
		main1.setIcon(new ImageIcon(MainFrame.class
				.getResource("/pictures/main.jpg")));
		main1.setBounds(0, 27, 1000, 154);
		jf1.getContentPane().add(main1);
		
		int x1=0,y=410;
		JLabel label_totalroom = new JLabel("高级大床房：200元");
		label_totalroom.setBounds(x1, y, 300, 15);
		jf1.getContentPane().add(label_totalroom);
		
		label_totalroom = new JLabel("标准间：180元");
		label_totalroom.setBounds(x1, y+20, 300, 15);
		jf1.getContentPane().add(label_totalroom);
		
		label_totalroom = new JLabel("家庭房：230元");
		label_totalroom.setBounds(x1, y+40, 216, 15);
		jf1.getContentPane().add(label_totalroom);
		
		label_totalroom = new JLabel("豪华套房：300元");
		label_totalroom.setBounds(x1, y+60, 216, 15);
		jf1.getContentPane().add(label_totalroom);

		JLabel lblNewLabel_10 = new JLabel("入住天数：");
		lblNewLabel_10.setBounds(124, 198, 66, 15);
		jf1.getContentPane().add(lblNewLabel_10);

		// 更改房间的图片。如果已登记或入住，则显示为已住否则显示为未住
		// 房间101
		JLabel room101 = new JLabel("New label");
		if (data_mainframe.rState("101")) {
			room101.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/高级大床房.jpg")));
		} else {
			room101.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/高级大床房未住.jpg")));
		}
		room101.setBounds(110, 215, 102, 74);
		jf1.getContentPane().add(room101);

		// 房间201
		JLabel room201 = new JLabel("New label");
		if (data_mainframe.rState("201")) {
			room201.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/高级大床房.jpg")));
		} else {
			room201.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/高级大床房未住.jpg")));
		}
		room201.setBounds(110, 330, 102, 74);
		jf1.getContentPane().add(room201);

		// 房间301
		JLabel room301 = new JLabel("New label");
		if (data_mainframe.rState("301")) {
			room301.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/高级大床房.jpg")));
		} else {
			room301.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/高级大床房未住.jpg")));
		}
		room301.setBounds(110, 445, 102, 74);
		jf1.getContentPane().add(room301);

		// 房间102
		JLabel room102 = new JLabel("New label");
		if (data_mainframe.rState("102")) {
			room102.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间.jpg")));
		} else {
			room102.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间未住.jpg")));
		}
		room102.setBounds(232, 215, 102, 74);
		jf1.getContentPane().add(room102);

		// 房间202
		JLabel room202 = new JLabel("New label");
		if (data_mainframe.rState("202")) {
			room202.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间.jpg")));
		} else {
			room202.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间未住.jpg")));
		}
		room202.setBounds(232, 330, 102, 74);
		jf1.getContentPane().add(room202);

		// 房间302 标准间
		JLabel room302 = new JLabel("New label");
		if (data_mainframe.rState("302")) {
			room302.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间.jpg")));
		} else {
			room302.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间未住.jpg")));
		}
		room302.setBounds(232, 445, 102, 74);
		jf1.getContentPane().add(room302);

		// 房间103
		JLabel room103 = new JLabel("New label");
		if (data_mainframe.rState("103")) {
			room103.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间.jpg")));
		} else {
			room103.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间未住.jpg")));
		}
		room103.setBounds(354, 215, 102, 74);
		jf1.getContentPane().add(room103);

		// 房间203
		JLabel room203 = new JLabel("New label");
		if (data_mainframe.rState("203")) {
			room203.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间.jpg")));
		} else {
			room203.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间未住.jpg")));
		}
		room203.setBounds(354, 330, 102, 74);
		jf1.getContentPane().add(room203);

		// 房间303
		JLabel room303 = new JLabel("New label");
		if (data_mainframe.rState("303")) {
			room303.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间.jpg")));
		} else {
			room303.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间未住.jpg")));
		}
		room303.setBounds(354, 445, 102, 74);
		jf1.getContentPane().add(room303);

		// 房间104
		JLabel room104 = new JLabel("New label");
		if (data_mainframe.rState("104")) {
			room104.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间.jpg")));
		} else {
			room104.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间未住.jpg")));
		}
		room104.setBounds(476, 215, 102, 74);
		jf1.getContentPane().add(room104);

		// 房间204
		JLabel room204 = new JLabel("New label");
		if (data_mainframe.rState("204")) {
			room204.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间.jpg")));
		} else {
			room204.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间未住.jpg")));
		}
		room204.setBounds(476, 330, 102, 74);
		jf1.getContentPane().add(room204);

		// 房间304
		JLabel room304 = new JLabel("New label");
		if (data_mainframe.rState("304")) {
			room304.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间.jpg")));
		} else {
			room304.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/标准间未住.jpg")));
		}
		room304.setBounds(476, 445, 102, 74);
		jf1.getContentPane().add(room304);

		// 房间105
		JLabel room105 = new JLabel("New label");
		if (data_mainframe.rState("105")) {
			room105.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/家庭房.jpg")));
		} else {
			room105.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/家庭房未住.jpg")));
		}
		room105.setBounds(598, 215, 102, 74);
		jf1.getContentPane().add(room105);

		// 房间205
		JLabel room205 = new JLabel("New label");
		if (data_mainframe.rState("205")) {
			room205.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/家庭房.jpg")));
		} else {
			room205.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/家庭房未住.jpg")));
		}
		room205.setBounds(598, 330, 102, 74);
		jf1.getContentPane().add(room205);

		// 房间305
		JLabel room305 = new JLabel("New label");
		if (data_mainframe.rState("305")) {
			room305.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/家庭房.jpg")));
		} else {
			room305.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/家庭房未住.jpg")));
		}
		room305.setBounds(598, 445, 102, 74);
		jf1.getContentPane().add(room305);

		// 房间106
		JLabel room106 = new JLabel("New label");
		if (data_mainframe.rState("106")) {
			room106.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/豪华套房.jpg")));
		} else {
			room106.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/豪华套房未住.jpg")));
		}
		room106.setBounds(720, 215, 102, 74);
		jf1.getContentPane().add(room106);

		// 房间206
		JLabel room206 = new JLabel("New label");
		if (data_mainframe.rState("206")) {
			room206.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/豪华套房.jpg")));
		} else {
			room206.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/豪华套房未住.jpg")));
		}
		room206.setBounds(720, 330, 102, 74);
		jf1.getContentPane().add(room206);

		// 房间306
		JLabel room306 = new JLabel("New label");
		if (data_mainframe.rState("306")) {
			room306.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/豪华套房.jpg")));
		} else {
			room306.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/豪华套房未住.jpg")));
		}
		room306.setBounds(720, 445, 102, 74);
		jf1.getContentPane().add(room306);

		// 房间107
		JLabel room107 = new JLabel("New label");
		if (data_mainframe.rState("107")) {
			room107.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/高级大床房.jpg")));
		} else {
			room107.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/高级大床房未住.jpg")));
		}
		room107.setBounds(844, 215, 102, 74);
		jf1.getContentPane().add(room107);

		// 房间207
		JLabel room207 = new JLabel("New label");
		if (data_mainframe.rState("207")) {
			room207.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/高级大床房.jpg")));
		} else {
			room207.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/高级大床房未住.jpg")));
		}
		room207.setBounds(844, 330, 102, 74);
		jf1.getContentPane().add(room207);

		// 房间307
		JLabel room307 = new JLabel("New label");
		if (data_mainframe.rState("307")) {
			room307.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/高级大床房.jpg")));
		} else {
			room307.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/高级大床房未住.jpg")));
		}
		room307.setBounds(844, 445, 102, 74);
		jf1.getContentPane().add(room307);

		JLabel label_room101 = new JLabel("101：高级大床房");
		label_room101.setBounds(110, 299, 102, 26);
		jf1.getContentPane().add(label_room101);

		JLabel label_room201 = new JLabel("201：高级大床房");
		label_room201.setBounds(110, 414, 102, 26);
		jf1.getContentPane().add(label_room201);

		JLabel label_room301 = new JLabel("301：高级大床房");
		label_room301.setBounds(110, 529, 102, 26);
		jf1.getContentPane().add(label_room301);

		JLabel label_room102 = new JLabel("   102：标准间");
		label_room102.setBounds(232, 299, 102, 26);
		jf1.getContentPane().add(label_room102);

		JLabel label_room202 = new JLabel("   202：标准间");
		label_room202.setBounds(232, 414, 102, 26);
		jf1.getContentPane().add(label_room202);

		JLabel label_room302 = new JLabel("   302：标准间");
		label_room302.setBounds(232, 529, 102, 26);
		jf1.getContentPane().add(label_room302);

		JLabel label_room103 = new JLabel("   103：标准间");
		label_room103.setBounds(354, 299, 102, 26);
		jf1.getContentPane().add(label_room103);

		JLabel label_room203 = new JLabel("   203：标准间");
		label_room203.setBounds(354, 414, 102, 26);
		jf1.getContentPane().add(label_room203);

		JLabel label_room303 = new JLabel("   303：标准间");
		label_room303.setBounds(354, 529, 102, 23);
		jf1.getContentPane().add(label_room303);

		JLabel label_room104 = new JLabel("   104：标准间");
		label_room104.setBounds(476, 299, 102, 26);
		jf1.getContentPane().add(label_room104);

		JLabel label_room204 = new JLabel("   204：标准间");
		label_room204.setBounds(476, 414, 102, 26);
		jf1.getContentPane().add(label_room204);

		JLabel label_room304 = new JLabel("   304：标准间");
		label_room304.setBounds(476, 529, 93, 26);
		jf1.getContentPane().add(label_room304);

		JLabel label_room105 = new JLabel("   105：家庭房");
		label_room105.setBounds(598, 299, 102, 26);
		jf1.getContentPane().add(label_room105);

		JLabel label_room205 = new JLabel("   205：家庭房");
		label_room205.setBounds(598, 414, 102, 26);
		jf1.getContentPane().add(label_room205);

		JLabel label_room305 = new JLabel("   305：家庭房");
		label_room305.setBounds(598, 529, 102, 26);
		jf1.getContentPane().add(label_room305);

		JLabel label_room106 = new JLabel("  106：豪华套房");
		label_room106.setBounds(720, 299, 102, 26);
		jf1.getContentPane().add(label_room106);

		JLabel label_room206 = new JLabel("  206：豪华套房");
		label_room206.setBounds(720, 414, 102, 26);
		jf1.getContentPane().add(label_room206);

		JLabel label_room306 = new JLabel("  306：豪华套房");
		label_room306.setBounds(720, 529, 102, 26);
		jf1.getContentPane().add(label_room306);

		JLabel label_room107 = new JLabel("107：高级大床房");
		label_room107.setBounds(844, 299, 102, 26);
		jf1.getContentPane().add(label_room107);

		JLabel label_room207 = new JLabel("207：高级大床房");
		label_room207.setBounds(844, 414, 102, 26);
		jf1.getContentPane().add(label_room207);

		JLabel label_room307 = new JLabel("307：高级大床房");
		label_room307.setBounds(844, 529, 102, 26);
		jf1.getContentPane().add(label_room307);

		JButton updaterstate = new JButton("更新房态");
		updaterstate.setBounds(10, 182, 93, 23);
		updaterstate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				data_mainframe.Updaterstate_book();
				data_mainframe.Updaterstate_checkin();
				jf1.dispose();
				new MainFrame(username);
			}
		});
		jf1.getContentPane().add(updaterstate);

		JLabel label_remainroom = new JLabel("当前剩余房间：");
		label_remainroom.setBounds(0, 215, 100, 15);
		jf1.getContentPane().add(label_remainroom);

		JLabel label_remiandcf = new JLabel("高级大床房：");
		label_remiandcf.setText("高级大床房:" + data_mainframe.dachuangfang() + "间");
		label_remiandcf.setBounds(10, 245, 90, 15);
		jf1.getContentPane().add(label_remiandcf);

		JLabel label_remainbzj = new JLabel("标准间：");
		label_remainbzj.setText("标准间:  " + data_mainframe.biaozhunjian() + "间");
		label_remainbzj.setBounds(10, 270, 81, 15);
		jf1.getContentPane().add(label_remainbzj);

		JLabel label_remainjtf = new JLabel("家庭房：");
		label_remainjtf.setText("家庭房:  " + data_mainframe.jiatingfang() + "间");
		label_remainjtf.setBounds(10, 295, 81, 15);
		jf1.getContentPane().add(label_remainjtf);

		JLabel label_remainhhtf = new JLabel("豪华套房：");
		label_remainhhtf.setText("豪华套房: " + data_mainframe.haohuataofang() + "间");
		label_remainhhtf.setBounds(10, 320, 90, 15);
		jf1.getContentPane().add(label_remainhhtf);

		jf1.setVisible(true);

	}

	public static void main(String[] args) {
		new MainFrame("nihao");
	}

}


