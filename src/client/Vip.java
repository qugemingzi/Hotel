package client;

//import server.Database;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Vip {
	private JFrame jf;
	// 会员制度说明
	public Vip() {
//		new Database();
		jf = new JFrame("会员制度及会员信息");
		jf.setSize(new Dimension(600, 400));
		jf.setLocation(new Point(300, 150));
		jf.setResizable(false);
		jf.getContentPane().setLayout(null);

		JLabel label_vipyhzc = new JLabel("会员优惠政策：");
		label_vipyhzc.setBounds(10, 13, 99, 15);
		label_vipyhzc.setForeground(Color.RED);
		jf.getContentPane().add(label_vipyhzc);

		JTextArea ta_vipyhzc = new JTextArea();
		ta_vipyhzc.setForeground(Color.yellow);
		ta_vipyhzc.setEditable(false);
		ta_vipyhzc.setText("\u4E00.\u623F\u4EF7\u4F18\u60E0\r\n    \u9EC4\u91D1\u4F1A\u5458\u6BCF\u665A\u623F\u4EF7\u7ACB\u51CF5\u5143\uFF0C\u767D\u91D1\u4F1A\u5458\u6BCF\u665A\u623F\u95F4\u7ACB\u51CF10\u5143\uFF0C\u94BB\u77F3\u4F1A\u5458\u6BCF\u665A\u623F\u4EF7\u7ACB\u51CF20\u5143\u3002\r\n\u4E8C.\u79EF\u5206\u6D3B\u52A8\r\n    \u4E0D\u540C\u7B49\u7EA7\u4F1A\u5458\u6BCF\u665A\u4EA7\u751F\u4E0D\u540C\u5206\u6570\u7684\u79EF\u5206\uFF0C\u9EC4\u91D1\u4F1A\u5458\u3001\u767D\u91D1\u4F1A\u5458\u6BCF\u665A\u4EA7\u751F\u4E0E\u623F\u8D39\u76F8\u540C\u7684\u79EF\u5206\uFF0C\r\n\u94BB\u77F3\u4F1A\u5458\u83B7\u5F97\u623F\u8D39\u4E24\u500D\u7684\u79EF\u5206\u3002\r\n\u4E09.\u79EF\u5206\u6362\u623F\r\n    \u672C\u5E97\u4F1A\u5458\u5728\u9884\u8BA2\u65F6\u53EF\u4F7F\u75282000\u79EF\u5206\u5151\u6362\u6807\u51C6\u95F4\u4E00\u665A\uFF0C\u4E5F\u53EF\u4F7F\u75283000\u79EF\u5206\u5151\u6362\u9AD8\u7EA7\u5927\u5E8A\u623F\u4E00\u665A\u3002\r\n  \r\n");
		ta_vipyhzc.setBounds(10, 38, 515, 141);
		ta_vipyhzc.setOpaque(false);
		jf.getContentPane().add(ta_vipyhzc);

		JLabel label_vipdjpd = new JLabel("会员等级评定：");
		label_vipdjpd.setBounds(10, 189, 99, 15);
		label_vipdjpd.setForeground(Color.RED);
		jf.getContentPane().add(label_vipdjpd);

		JTextArea ta_vipdjpd = new JTextArea();
		ta_vipdjpd.setForeground(Color.yellow);
		ta_vipdjpd.setEditable(false);
		ta_vipdjpd
				.setText("\u9EC4\u91D1\u4F1A\u5458        \u4E00\u5E74\u5185\u7D2F\u79EF\u5165\u4F4F5\u4E2A\u623F\u665A\uFF0C\u4FE1\u7528\u8BB0\u5F55\u826F\u597D\u3002\r\n\u767D\u91D1\u4F1A\u5458        \u4E00\u5E74\u5185\u7D2F\u79EF\u5165\u4F4F10\u4E2A\u623F\u665A\uFF0C\u4FE1\u7528\u8BB0\u5F55\u826F\u597D\u3002\r\n\u94BB\u77F3\u4F1A\u5458        \u4E00\u5E74\u5185\u7D2F\u79EF\u5165\u4F4F20\u4E2A\u623F\u665A\uFF0C\u4FE1\u7528\u8BB0\u5F55\u826F\u597D\u3002");
		ta_vipdjpd.setBounds(10, 214, 320, 64);
		ta_vipdjpd.setOpaque(false);
		jf.getContentPane().add(ta_vipdjpd);

		JButton button_vip = new JButton("本店会员");
		button_vip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Vipmember();
			}
		});
		button_vip.setBounds(165, 313, 93, 23);
		jf.getContentPane().add(button_vip);

		JButton button_vipbl = new JButton("办理会员");
		button_vipbl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Addvip();
			}
		});
		button_vipbl.setBounds(338, 313, 93, 23);
		jf.getContentPane().add(button_vipbl);

		JLabel label_background = new JLabel("背景图片");
		label_background.setIcon(new ImageIcon(Vip.class
				.getResource("/pictures/vip.jpg")));
		label_background.setBounds(0, 0, 594, 372);
		jf.getContentPane().add(label_background);
		jf.setVisible(true);
	}

	public static void main(String[] args) {
		new Vip();
	}
}
