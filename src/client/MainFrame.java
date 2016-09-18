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
		
		//������
		jf1 = new JFrame("�Ƶ����ϵͳ");
		jf1.setTitle("�Ƶ����ϵͳ");
		jf1.setResizable(false);
		jf1.setSize(new Dimension(1000, 600));
		jf1.setLocation(new Point(200, 100));
		jf1.getContentPane().setLayout(null);
		jf1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jf1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				int res = JOptionPane.showConfirmDialog(null, "ȷ���˳��Ƶ����ϵͳ��");
				if (res == JOptionPane.YES_OPTION) {
					jf1.dispose();
					System.exit(0);
					}
			}
		});

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 994, 26);
		jf1.getContentPane().add(menuBar);

		JMenu wenjian = new JMenu("�ļ�");
		wenjian.setAlignmentX(Component.LEFT_ALIGNMENT);
		menuBar.add(wenjian);

		JMenuItem restart = new JMenuItem("����ϵͳ");
		restart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				jf1.dispose();
				new MainFrame(username);
			}
		});
		wenjian.add(restart);

		JMenuItem exit = new JMenuItem("�˳�");
		exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "ȷ���˳��Ƶ����ϵͳ��");
				if (res == JOptionPane.YES_OPTION) {
					jf1.dispose();
					System.exit(0);
					}
			}
		});
		
		wenjian.add(exit);

		JMenu help = new JMenu("����");
		menuBar.add(help);

		final JMenuItem usehelp = new JMenuItem("ʹ��˵��");
		usehelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(usehelp, "help");
			}
		});
		help.add(usehelp);
       

		Calendar ca = Calendar.getInstance();
		year = ca.get(Calendar.YEAR);// ��ȡ���
		month = ca.get(Calendar.MONTH);// ��ȡ�·�
		day = ca.get(Calendar.DATE);// ��ȡ��
		minute = ca.get(Calendar.MINUTE);// ��
		hour = ca.get(Calendar.HOUR);// Сʱ
		second = ca.get(Calendar.SECOND);// ��
		
		//�gӭ
		JLabel label_welcome = new JLabel("welcome to " + username + " !");
		label_welcome.setBounds(x+15, 50, 600, 100);
		label_welcome.setFont(new Font("ITALIC",1,15));
		jf1.getContentPane().add(label_welcome);
		
		//Ԥ��
		JButton book = new JButton("Ԥ��");
		book.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/bookbutton.jpg")));
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Book();
			}
		});
		book.setToolTipText("Ԥ����Ϣ");
		book.setBounds(x+15, 125, 87, 50);
		jf1.getContentPane().add(book);
		
        //�Ǽ���ס
		JButton checkin = new JButton("�Ǽ�");
		checkin.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/checkinbutton.jpg")));
		checkin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Checkin("" + year + month + day + hour + minute + second);
			}
		});
		checkin.setToolTipText("��ס�Ǽ�");
		checkin.setBounds(x+148, 125, 87, 50);
		jf1.getContentPane().add(checkin);
        //����
		JButton huanfang = new JButton("����");
		huanfang.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/changebu.png")));
		huanfang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Change();
			}
		});
		huanfang.setToolTipText("��������");
		huanfang.setBounds(x+281, 125, 87, 50);
		jf1.getContentPane().add(huanfang);
        
		//����
		JButton jiezhang = new JButton("����");
		jiezhang.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/jiezhangbutton.jpg")));
		jiezhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Jiezhang();
			}
		});
		jiezhang.setToolTipText("�ͻ�����");
		jiezhang.setBounds(x+414, 125, 87, 50);
		jf1.getContentPane().add(jiezhang);

		//��Ա
		JButton vip = new JButton("��Ա");
		vip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Vip();
			}
		});
		vip.setIcon(new ImageIcon(MainFrame.class.getResource("/pictures/vipbutton.jpg")));
		vip.setToolTipText("��Ա�ƶ�");
		vip.setBounds(x+547, 125, 87, 50);
		jf1.getContentPane().add(vip);

		JLabel main1 = new JLabel("New label");
		main1.setIcon(new ImageIcon(MainFrame.class
				.getResource("/pictures/main.jpg")));
		main1.setBounds(0, 27, 1000, 154);
		jf1.getContentPane().add(main1);
		
		int x1=0,y=410;
		JLabel label_totalroom = new JLabel("�߼��󴲷���200Ԫ");
		label_totalroom.setBounds(x1, y, 300, 15);
		jf1.getContentPane().add(label_totalroom);
		
		label_totalroom = new JLabel("��׼�䣺180Ԫ");
		label_totalroom.setBounds(x1, y+20, 300, 15);
		jf1.getContentPane().add(label_totalroom);
		
		label_totalroom = new JLabel("��ͥ����230Ԫ");
		label_totalroom.setBounds(x1, y+40, 216, 15);
		jf1.getContentPane().add(label_totalroom);
		
		label_totalroom = new JLabel("�����׷���300Ԫ");
		label_totalroom.setBounds(x1, y+60, 216, 15);
		jf1.getContentPane().add(label_totalroom);

		JLabel lblNewLabel_10 = new JLabel("��ס������");
		lblNewLabel_10.setBounds(124, 198, 66, 15);
		jf1.getContentPane().add(lblNewLabel_10);

		// ���ķ����ͼƬ������ѵǼǻ���ס������ʾΪ��ס������ʾΪδס
		// ����101
		JLabel room101 = new JLabel("New label");
		if (data_mainframe.rState("101")) {
			room101.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�߼��󴲷�.jpg")));
		} else {
			room101.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�߼��󴲷�δס.jpg")));
		}
		room101.setBounds(110, 215, 102, 74);
		jf1.getContentPane().add(room101);

		// ����201
		JLabel room201 = new JLabel("New label");
		if (data_mainframe.rState("201")) {
			room201.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�߼��󴲷�.jpg")));
		} else {
			room201.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�߼��󴲷�δס.jpg")));
		}
		room201.setBounds(110, 330, 102, 74);
		jf1.getContentPane().add(room201);

		// ����301
		JLabel room301 = new JLabel("New label");
		if (data_mainframe.rState("301")) {
			room301.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�߼��󴲷�.jpg")));
		} else {
			room301.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�߼��󴲷�δס.jpg")));
		}
		room301.setBounds(110, 445, 102, 74);
		jf1.getContentPane().add(room301);

		// ����102
		JLabel room102 = new JLabel("New label");
		if (data_mainframe.rState("102")) {
			room102.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��.jpg")));
		} else {
			room102.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��δס.jpg")));
		}
		room102.setBounds(232, 215, 102, 74);
		jf1.getContentPane().add(room102);

		// ����202
		JLabel room202 = new JLabel("New label");
		if (data_mainframe.rState("202")) {
			room202.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��.jpg")));
		} else {
			room202.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��δס.jpg")));
		}
		room202.setBounds(232, 330, 102, 74);
		jf1.getContentPane().add(room202);

		// ����302 ��׼��
		JLabel room302 = new JLabel("New label");
		if (data_mainframe.rState("302")) {
			room302.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��.jpg")));
		} else {
			room302.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��δס.jpg")));
		}
		room302.setBounds(232, 445, 102, 74);
		jf1.getContentPane().add(room302);

		// ����103
		JLabel room103 = new JLabel("New label");
		if (data_mainframe.rState("103")) {
			room103.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��.jpg")));
		} else {
			room103.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��δס.jpg")));
		}
		room103.setBounds(354, 215, 102, 74);
		jf1.getContentPane().add(room103);

		// ����203
		JLabel room203 = new JLabel("New label");
		if (data_mainframe.rState("203")) {
			room203.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��.jpg")));
		} else {
			room203.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��δס.jpg")));
		}
		room203.setBounds(354, 330, 102, 74);
		jf1.getContentPane().add(room203);

		// ����303
		JLabel room303 = new JLabel("New label");
		if (data_mainframe.rState("303")) {
			room303.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��.jpg")));
		} else {
			room303.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��δס.jpg")));
		}
		room303.setBounds(354, 445, 102, 74);
		jf1.getContentPane().add(room303);

		// ����104
		JLabel room104 = new JLabel("New label");
		if (data_mainframe.rState("104")) {
			room104.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��.jpg")));
		} else {
			room104.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��δס.jpg")));
		}
		room104.setBounds(476, 215, 102, 74);
		jf1.getContentPane().add(room104);

		// ����204
		JLabel room204 = new JLabel("New label");
		if (data_mainframe.rState("204")) {
			room204.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��.jpg")));
		} else {
			room204.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��δס.jpg")));
		}
		room204.setBounds(476, 330, 102, 74);
		jf1.getContentPane().add(room204);

		// ����304
		JLabel room304 = new JLabel("New label");
		if (data_mainframe.rState("304")) {
			room304.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��.jpg")));
		} else {
			room304.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��׼��δס.jpg")));
		}
		room304.setBounds(476, 445, 102, 74);
		jf1.getContentPane().add(room304);

		// ����105
		JLabel room105 = new JLabel("New label");
		if (data_mainframe.rState("105")) {
			room105.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��ͥ��.jpg")));
		} else {
			room105.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��ͥ��δס.jpg")));
		}
		room105.setBounds(598, 215, 102, 74);
		jf1.getContentPane().add(room105);

		// ����205
		JLabel room205 = new JLabel("New label");
		if (data_mainframe.rState("205")) {
			room205.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��ͥ��.jpg")));
		} else {
			room205.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��ͥ��δס.jpg")));
		}
		room205.setBounds(598, 330, 102, 74);
		jf1.getContentPane().add(room205);

		// ����305
		JLabel room305 = new JLabel("New label");
		if (data_mainframe.rState("305")) {
			room305.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��ͥ��.jpg")));
		} else {
			room305.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/��ͥ��δס.jpg")));
		}
		room305.setBounds(598, 445, 102, 74);
		jf1.getContentPane().add(room305);

		// ����106
		JLabel room106 = new JLabel("New label");
		if (data_mainframe.rState("106")) {
			room106.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�����׷�.jpg")));
		} else {
			room106.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�����׷�δס.jpg")));
		}
		room106.setBounds(720, 215, 102, 74);
		jf1.getContentPane().add(room106);

		// ����206
		JLabel room206 = new JLabel("New label");
		if (data_mainframe.rState("206")) {
			room206.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�����׷�.jpg")));
		} else {
			room206.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�����׷�δס.jpg")));
		}
		room206.setBounds(720, 330, 102, 74);
		jf1.getContentPane().add(room206);

		// ����306
		JLabel room306 = new JLabel("New label");
		if (data_mainframe.rState("306")) {
			room306.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�����׷�.jpg")));
		} else {
			room306.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�����׷�δס.jpg")));
		}
		room306.setBounds(720, 445, 102, 74);
		jf1.getContentPane().add(room306);

		// ����107
		JLabel room107 = new JLabel("New label");
		if (data_mainframe.rState("107")) {
			room107.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�߼��󴲷�.jpg")));
		} else {
			room107.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�߼��󴲷�δס.jpg")));
		}
		room107.setBounds(844, 215, 102, 74);
		jf1.getContentPane().add(room107);

		// ����207
		JLabel room207 = new JLabel("New label");
		if (data_mainframe.rState("207")) {
			room207.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�߼��󴲷�.jpg")));
		} else {
			room207.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�߼��󴲷�δס.jpg")));
		}
		room207.setBounds(844, 330, 102, 74);
		jf1.getContentPane().add(room207);

		// ����307
		JLabel room307 = new JLabel("New label");
		if (data_mainframe.rState("307")) {
			room307.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�߼��󴲷�.jpg")));
		} else {
			room307.setIcon(new ImageIcon(MainFrame.class
					.getResource("/pictures/�߼��󴲷�δס.jpg")));
		}
		room307.setBounds(844, 445, 102, 74);
		jf1.getContentPane().add(room307);

		JLabel label_room101 = new JLabel("101���߼��󴲷�");
		label_room101.setBounds(110, 299, 102, 26);
		jf1.getContentPane().add(label_room101);

		JLabel label_room201 = new JLabel("201���߼��󴲷�");
		label_room201.setBounds(110, 414, 102, 26);
		jf1.getContentPane().add(label_room201);

		JLabel label_room301 = new JLabel("301���߼��󴲷�");
		label_room301.setBounds(110, 529, 102, 26);
		jf1.getContentPane().add(label_room301);

		JLabel label_room102 = new JLabel("   102����׼��");
		label_room102.setBounds(232, 299, 102, 26);
		jf1.getContentPane().add(label_room102);

		JLabel label_room202 = new JLabel("   202����׼��");
		label_room202.setBounds(232, 414, 102, 26);
		jf1.getContentPane().add(label_room202);

		JLabel label_room302 = new JLabel("   302����׼��");
		label_room302.setBounds(232, 529, 102, 26);
		jf1.getContentPane().add(label_room302);

		JLabel label_room103 = new JLabel("   103����׼��");
		label_room103.setBounds(354, 299, 102, 26);
		jf1.getContentPane().add(label_room103);

		JLabel label_room203 = new JLabel("   203����׼��");
		label_room203.setBounds(354, 414, 102, 26);
		jf1.getContentPane().add(label_room203);

		JLabel label_room303 = new JLabel("   303����׼��");
		label_room303.setBounds(354, 529, 102, 23);
		jf1.getContentPane().add(label_room303);

		JLabel label_room104 = new JLabel("   104����׼��");
		label_room104.setBounds(476, 299, 102, 26);
		jf1.getContentPane().add(label_room104);

		JLabel label_room204 = new JLabel("   204����׼��");
		label_room204.setBounds(476, 414, 102, 26);
		jf1.getContentPane().add(label_room204);

		JLabel label_room304 = new JLabel("   304����׼��");
		label_room304.setBounds(476, 529, 93, 26);
		jf1.getContentPane().add(label_room304);

		JLabel label_room105 = new JLabel("   105����ͥ��");
		label_room105.setBounds(598, 299, 102, 26);
		jf1.getContentPane().add(label_room105);

		JLabel label_room205 = new JLabel("   205����ͥ��");
		label_room205.setBounds(598, 414, 102, 26);
		jf1.getContentPane().add(label_room205);

		JLabel label_room305 = new JLabel("   305����ͥ��");
		label_room305.setBounds(598, 529, 102, 26);
		jf1.getContentPane().add(label_room305);

		JLabel label_room106 = new JLabel("  106�������׷�");
		label_room106.setBounds(720, 299, 102, 26);
		jf1.getContentPane().add(label_room106);

		JLabel label_room206 = new JLabel("  206�������׷�");
		label_room206.setBounds(720, 414, 102, 26);
		jf1.getContentPane().add(label_room206);

		JLabel label_room306 = new JLabel("  306�������׷�");
		label_room306.setBounds(720, 529, 102, 26);
		jf1.getContentPane().add(label_room306);

		JLabel label_room107 = new JLabel("107���߼��󴲷�");
		label_room107.setBounds(844, 299, 102, 26);
		jf1.getContentPane().add(label_room107);

		JLabel label_room207 = new JLabel("207���߼��󴲷�");
		label_room207.setBounds(844, 414, 102, 26);
		jf1.getContentPane().add(label_room207);

		JLabel label_room307 = new JLabel("307���߼��󴲷�");
		label_room307.setBounds(844, 529, 102, 26);
		jf1.getContentPane().add(label_room307);

		JButton updaterstate = new JButton("���·�̬");
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

		JLabel label_remainroom = new JLabel("��ǰʣ�෿�䣺");
		label_remainroom.setBounds(0, 215, 100, 15);
		jf1.getContentPane().add(label_remainroom);

		JLabel label_remiandcf = new JLabel("�߼��󴲷���");
		label_remiandcf.setText("�߼��󴲷�:" + data_mainframe.dachuangfang() + "��");
		label_remiandcf.setBounds(10, 245, 90, 15);
		jf1.getContentPane().add(label_remiandcf);

		JLabel label_remainbzj = new JLabel("��׼�䣺");
		label_remainbzj.setText("��׼��:  " + data_mainframe.biaozhunjian() + "��");
		label_remainbzj.setBounds(10, 270, 81, 15);
		jf1.getContentPane().add(label_remainbzj);

		JLabel label_remainjtf = new JLabel("��ͥ����");
		label_remainjtf.setText("��ͥ��:  " + data_mainframe.jiatingfang() + "��");
		label_remainjtf.setBounds(10, 295, 81, 15);
		jf1.getContentPane().add(label_remainjtf);

		JLabel label_remainhhtf = new JLabel("�����׷���");
		label_remainhhtf.setText("�����׷�: " + data_mainframe.haohuataofang() + "��");
		label_remainhhtf.setBounds(10, 320, 90, 15);
		jf1.getContentPane().add(label_remainhhtf);

		jf1.setVisible(true);

	}

	public static void main(String[] args) {
		new MainFrame("nihao");
	}

}


