package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Server {
	private int port = 8888;
	private ServerSocket ss;
	private Database data_server;
	private JFrame jf;
	private JPanel jp1;
	private List lis;
	private ArrayList<String> Username = new ArrayList<String>();
	private static Hashtable<String, DataOutputStream> userList;
	private DataOutputStream dos;
	private DataInputStream dis;

	//服务器界面
	public Server() {
		data_server = new Database();        
		userList = new Hashtable<String, DataOutputStream>();
		jf = new JFrame("服务器");
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				data_server.Exit();
				Close();
				System.exit(0);
			}
		});
		jp1 = new JPanel();
		jp1.setLayout(new BorderLayout(10, 10));
		lis = new List();
		jp1.add(lis);
		jp1.add(new JLabel("在线用户"), BorderLayout.NORTH);
		jp1.add(new JLabel(" "), BorderLayout.SOUTH);
		jp1.add(new JLabel(" "), BorderLayout.WEST);
		jp1.add(new JLabel(" "), BorderLayout.EAST);
		JS js = new JS();
		js.start();
		jf.getContentPane().add(jp1);
		jf.setLocation(400, 200);
		jf.setSize(300, 450);
		jf.setResizable(true);
		jf.setVisible(true);
		try {
			ss = new ServerSocket(port);

			while (true) {
				Socket soc = ss.accept();
				dis = new DataInputStream(soc.getInputStream());
				dos = new DataOutputStream(soc.getOutputStream());
				String first = dis.readUTF();
				String username = "";
				String password = "";
				// 判断登录
				if (first.substring(0, 2).equals("$a")) {
					username = first.substring(2, first.length());
					String []str = username.split("/");
					username = str[0];
					password = str[1];
					//如果有用户表中有说明已经登录
					if (Username.contains(username)) {
						dos.writeUTF("#s");
					} else if (data_server.AdminRegister(username, password)) {
						Username.add(username);
						dos.writeUTF("$d");
						userList.put(username, dos);
					} else if (data_server.Register(username, password)) {
						Username.add(username);
						dos.writeUTF("$b");
						userList.put(username, dos);
					} else {
						dos.writeUTF("$c");
					}
					dis.close();
					dos.close();
				}
			}
		} catch (SocketException e) {
			JOptionPane.showMessageDialog(null, "服务器端出现网络问题！");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "服务器端出现错误！");
		}

	}

	public void Close() {
		try {
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();
	}

	//线程更新，10秒自动更新一次
	class JS extends Thread {
		public void run() {
			try {
				while (true) {
					Thread.sleep(10000);
					lis.removeAll();
					for (int i = 0; i < Username.size(); i++) {
						lis.add(Username.get(i));
					}
				}
			}

			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
