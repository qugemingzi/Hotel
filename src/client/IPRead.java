package client;


import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

//读取获取服务器连接
public class IPRead 
{
	private String IP="1";
	private int port=0;
	
	@SuppressWarnings("resource")
	IPRead(){
		try{
			Scanner file=new Scanner(new File("DNS.txt"));
			String str=file.nextLine();
			if(str.equals("")){
				return;
			}else{
				String line[] = str.split(":");
				IP=line[0];
				port=Integer.parseInt(line[1]);
				file.close();
			}
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"服务器地址格式有误！");
		}catch (NoSuchElementException e) {
			JOptionPane.showMessageDialog(null,"读取服务器地址出错！");
		}catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"DNS文件位置出错！");
		}
	}
	
	public String getIP(){
		return IP;
	}
	public int getPort(){
		return port;
	}
	
}

