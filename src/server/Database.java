package server;

import server.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Database {
	private static Connection conn;
	private static Database datamain = null;

	public Database() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/hotel?characterEncoding=utf8",
					"root", "081221");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "文件未找到！");
			System.exit(-1);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "连接数据库出错！");
			System.exit(-1);
		}
		if (conn != null) {
			System.out.println("数据库连接成功！");
		}
	}

	// 更新房间状态，使预定的房间状态由false改为true
	public void Updaterstate_book() {
		try {
			PreparedStatement ps_update = null;
			ps_update = conn
					.prepareStatement("update room join book on room.rid = book.brnum set room.rstate='true';");
			ps_update.execute();
			ps_update.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 使登记的房间状态由false改为true
	public void Updaterstate_checkin() {
		try {
			PreparedStatement update = null;
			update = conn
					.prepareStatement("update room join checkin on room.rid = checkin.crnum and checkin.ccheckoutornot='false' set room.rstate='true';");
			update.execute();
			update.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 退出
	public void Exit() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 判断能否登录
	public boolean Register(String username, String password) {
		boolean res = false;
		try {
			String str = "select * from user";
			Statement s_register = conn.createStatement();
			ResultSet rs = s_register.executeQuery(str);
			while (rs.next()) {
				String str_username = rs.getString("username");
				String str_password = rs.getString("password");
				if (str_password.equals(password)
						&& str_username.equals(username)) {
					res = true;
				}
			}
			rs.close();
			s_register.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 判断能否登录
	public boolean AdminRegister(String username, String password) {
		boolean res = false;
		try {
			String str = "select * from user";
			Statement s_adminregister = conn.createStatement();
			ResultSet rs = s_adminregister.executeQuery(str);
			while (rs.next()) {
				String str_username = rs.getString("username");
				String str_password = rs.getString("password");
				String str_flag = rs.getString("flag");
				if (str_password.equals(password)
						&& str_username.equals(username)
						&& str_flag.equals("true")) {
					res = true;
				}
			}
			rs.close();
			s_adminregister.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 返回该房间号的房态
	public boolean rState(String name) {
		boolean res = false;
		try {
			String str = "select rstate from room where rid=" + name;
			Statement s_state = conn.createStatement();
			ResultSet rs = s_state.executeQuery(str);
			rs.next();
			String panduan = rs.getString("rstate");
			if (panduan.equals("true")) {
				res = true;
			}
			rs.close();
			s_state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	// 返回当前各种房型的剩余间数
	// 大床房
	public String dachuangfang() {
		int i = 0;
		try {
			String str = "select * from room where rtype='高级大床房' and rstate='false'";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			while (rs.next()) {
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i + "";
	}

	// 标准间
	public String biaozhunjian() {
		int i = 0;
		try {
			String str = "select * from room where rtype='标准间' and rstate='false'";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			while (rs.next()) {
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i + "";

	}

	// 家庭房
	public String jiatingfang() {
		int i = 0;
		try {
			String str = "select * from room where rtype='家庭房' and rstate='false'";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			while (rs.next()) {
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i + "";

	}

	// 豪华套房
	public String haohuataofang() {
		int i = 0;
		try {
			String str = "select * from room where rtype='豪华套房' and rstate='false'";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			while (rs.next()) {
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i + "";

	}

	// 返回有多少条预定
	public int getBookNum() {
		int ans = 0;
		try {
			String str = "select * from book";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			rs.last();
			ans = rs.getRow();
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ans;
	}

	// 将预定信息存入二维数组
	public String[][] bookData() {
		datamain = new Database();
		int a = datamain.getBookNum();
		String[][] data = new String[a][10];
		int i = 0;
		try {
			String str = "select * from book";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			while (rs.next()) {
				data[i][0] = rs.getString("bid");
				data[i][1] = rs.getString("bname");
				data[i][2] = rs.getString("bsex");
				data[i][3] = rs.getString("bpnum");
				data[i][4] = rs.getString("bidcard");
				data[i][5] = rs.getString("brnum");
				data[i][6] = rs.getString("bday");
				data[i][7] = rs.getString("bholdtime");
				data[i][8] = rs.getString("bsummoney");
				data[i][9] = rs.getString("bps");
				i++;
			}
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int as = 0; as < a; as++) {
			for (int ad = 0; ad < 10; ad++) {
				System.out.printf(data[as][ad] + " ");
			}
			System.out.println("");
		}
		return data;
	}

	// 办理会员
	public String stringVipLevel(String name) {
		String vl = "非会员";
		try {
			String str = "select vlevel from vip where vname='" + name + "'";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			while (rs.next()) {
				if (rs.getString("vlevel").equals("钻石会员")) {
					vl = "钻石会员";
				} else if (rs.getString("vlevel").equals("白金会员")) {
					vl = "白金会员";
				} else if (rs.getString("vlevel").equals("黄金会员")) {
					vl = "黄金会员";
				}
			}
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vl;
	}

	// 将登记数据存入数据库
	public boolean Checkin(String id, String name, String sex, String pnum,
			String idcard, String rnum, String money, String checkin,
			String day, String cash, String ps, String level) {
		boolean res = false;
		String str = "insert into checkin(cid,cname,csex,cpnum,cidcard,crnum,"
				+ "cmoney,ccheckin,ccheckout,cday,ccash,ccheckoutornot,cps,clevel)"
				+ "values('"
				+ id
				+ "','"
				+ name
				+ "','"
				+ sex
				+ "','"
				+ pnum
				+ "','"
				+ idcard
				+ "','"
				+ rnum
				+ "','"
				+ money
				+ "','"
				+ checkin
				+ "','null','"
				+ day
				+ "','"
				+ cash
				+ "','false','"
				+ ps
				+ "','" + level + "')";
		Statement state;
		try {
			state = conn.createStatement();
			state.executeUpdate(str);
			state.close();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 使用积分换房时减积分
	public void jianQuJiFen(String name, int jifen) {
		try {
			String str = "update vip set vpoints=vpoints-" + jifen
					+ " where vname='" + name + "'";
			Statement state = conn.createStatement();
			state.executeUpdate(str);
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 删除已入住的预定
	public void deleteBookCheckin(String rnum) {
		try {
			String str = "delete from book where brnum='" + rnum + "';";
			Statement state = conn.createStatement();
			state.executeUpdate(str);
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 预订房间
	public boolean yuding(String bid, String bname, String bsex, String bpnum,
			String bidcard, String brnum, String bday, String bholdtime,
			String bsummoney, String bps) {
		boolean res2 = false;
		String str = "insert into book(bid,bname,bsex,bpnum,bidcard,brnum,bday,bholdtime,bsummoney,bps)values('"
				+ bid
				+ "','"
				+ bname
				+ "','"
				+ bsex
				+ "','"
				+ bpnum
				+ "','"
				+ bidcard
				+ "','"
				+ brnum
				+ "','"
				+ bday
				+ "','"
				+ bholdtime
				+ "','" + bsummoney + "','" + bps + "')";
		Statement state;
		try {
			state = conn.createStatement();
			state.executeUpdate(str);
			state.close();
			res2 = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res2;
	}

	// 返回该房间号的房间类型
	public String rType(String num) {
		String type = null;
		try {
			String str = "select rtype from room where rid=" + num;
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			rs.next();
			type = rs.getString("rtype");
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}

	// 返回该房号的房价
	public int rRate(String num) {
		String rate = null;
		try {
			String str = "select rrate from room where rid=" + num;
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			rs.next();
			rate = rs.getString("rrate");
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(rate);
	}

	// 返回该房号的房间面积
	public String rSize(String num) {
		String size = null;
		try {
			String str = "select rsize from room where rid=" + num;
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			rs.next();
			size = rs.getString("rsize");
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return size;
	}

	// 返回该房号的床数
	public String rBednum(String num) {
		String bednum = null;
		try {
			String str = "select rbednum from room where rid=" + num;
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			rs.next();
			bednum = rs.getString("rbednum");
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bednum;
	}

	// 返回该房号的ID
	public String cId(String rnum) {
		String id = null;
		try {
			String str = "select cid from checkin where crnum='" + rnum
					+ "'and ccheckoutornot='false'";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			while (rs.next()) {
				id = rs.getString("cid");
			}
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	// 返回该房号用户的Idcard
	public String cIdcard(String rnum) {
		String idcard = null;
		try {
			String str = "select cidcard from checkin where crnum='" + rnum
					+ "'and ccheckoutornot='false'";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			while (rs.next()) {
				idcard = rs.getString("cidcard");
			}
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idcard;
	}

	// 入住与否******入住为false，没入住为true
	public boolean cMeiruzhu(String rnum) {
		boolean res = true;
		try {
			String str = "select crnum from checkin where ccheckoutornot='false'";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			while (rs.next()) {
				if (rs.getString("crnum").equals(rnum)) {
					res = false;
				}
			}
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 积分换房的房间无法更换，返回备注
	public String cPs(String rnum) {
		String ps = null;
		try {
			String str = "select cps from checkin where crnum='" + rnum
					+ "'and ccheckoutornot='false'";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			rs.next();
			ps = rs.getString("cps");
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	// 返回该房间号的姓名
	public String cName(String rnum) {
		String name = null;
		try {
			String str = "select cname from checkin where crnum='" + rnum
					+ "'and ccheckoutornot='false'";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			rs.next();
			name = rs.getString("cname");
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}

	// 金额花费
	public String cMoney(String rnum) {
		String money = null;
		try {
			String str = "select cmoney from checkin where crnum='" + rnum
					+ "'and ccheckoutornot='false'";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			rs.next();
			money = rs.getString("cmoney");
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return money;
	}

	// 需要住的时间
	public String cDay(String rnum) {
		String day = null;
		try {
			String str = "select cday from checkin where crnum='" + rnum
					+ "'and ccheckoutornot='false'";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			rs.next();
			day = rs.getString("cday");
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return day;
	}

	// 预定房间号*****已预定为true，未预订为false
	public boolean cYiyuding(String rnum) {
		boolean res = false;
		try {
			String str = "select brnum from book";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			while (rs.next()) {
				if (rs.getString("brnum").equals(rnum)) {
					res = true;
				}
			}
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 换房设置金额****成功为true，失败为false
	public boolean changeMoney(String id, String moneyi) {
		boolean res = false;
		try {
			String str = "update checkin set cmoney='" + moneyi
					+ "元' where cid='" + id + "';";
			Statement state = conn.createStatement();
			state.executeUpdate(str);
			state.close();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 换房设置房号****成功为true，失败为false
	public boolean changeRnum(String id, String rnumi) {
		boolean res = false;
		try {
			String str = "update checkin set crnum='" + rnumi + "' where cid='"
					+ id + "';";
			Statement state = conn.createStatement();
			state.executeUpdate(str);
			state.close();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 换房之后房号状态为已住****成功为true，失败为false
	public boolean changeRstate_rnumi(String rnumi) {
		boolean res = false;
		try {
			String str = "update room set rstate='true' where rid='" + rnumi
					+ "';";
			Statement state = conn.createStatement();
			state.executeUpdate(str);
			state.close();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 换房前床号状态为未住****成功为true，失败为false
	public boolean changeRstate_rnume(String rnume) {
		boolean res = false;
		try {
			String str = "update room set rstate='false' where rid='" + rnume
					+ "';";
			Statement state = conn.createStatement();
			state.executeUpdate(str);
			state.close();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 返回电话号码
	public String cPnum(String rnum) {
		String pnum = null;
		try {
			String str = "select cpnum from checkin where crnum='" + rnum
					+ "'and ccheckoutornot='false'";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			rs.next();
			pnum = rs.getString("cpnum");
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pnum;
	}

	// 登记入住时间
	public String cCheckin(String rnum) {
		String checkin = null;
		try {
			String str = "select ccheckin from checkin where crnum='" + rnum
					+ "'and ccheckoutornot='false'";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			rs.next();
			checkin = rs.getString("ccheckin");
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkin;
	}

	// 押金
	public String cCash(String rnum) {
		String cash = null;
		try {
			String str = "select ccash from checkin where crnum='" + rnum
					+ "'and ccheckoutornot='false'";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			rs.next();
			cash = rs.getString("ccash");
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cash;
	}

	// Vip 等级，钻石为2，白金/黄金为1
	public int vipLevel(String name) {
		int viplevel = 0;
		try {
			String str = "select vlevel from vip where vname ='" + name + "'";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			while (rs.next()) {
				if (rs.getString("vlevel").equals("钻石会员")) {
					viplevel = 2;
				} else if (rs.getString("vlevel").equals("白金会员")
						|| rs.getString("vlevel").equals("黄金会员")) {
					viplevel = 1;
				}
			}
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return viplevel;
	}

	// 结账****成功为true，失败为false
	public boolean checkOut(String rnum, String checkout) {
		boolean res = false;
		try {
			String str = "update checkin set ccheckout='" + checkout
					+ "' where crnum='" + rnum + "';";
			Statement state = conn.createStatement();
			state.executeUpdate(str);
			state.close();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 记为已结账****成功为true，失败为false
	public boolean checkOutOrNot(String rnum) {
		boolean res = false;
		try {
			String str = "update checkin set ccheckoutornot='true' where crnum='"
					+ rnum + "';";
			Statement state = conn.createStatement();
			state.executeUpdate(str);
			state.close();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 结账时加房晚****成功为true，失败为false
	public boolean jiaFangWan(String name) {
		boolean res = false;
		try {
			String str = "update vip set fangwannum=fangwannum+1 where vname='"
					+ name + "'";
			Statement state = conn.createStatement();
			state.executeUpdate(str);
			state.close();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 结账时Vip加积分****成功为true，失败为false
	public boolean jiaJiFen(String name, int jifen) {
		boolean res = false;
		try {
			String str = "update vip set vpoints=vpoints+" + jifen
					+ " where vname='" + name + "'";
			Statement state = conn.createStatement();
			state.executeUpdate(str);
			state.close();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 返回有多少个会员
	public int getVipNum() {
		int ans = 0;
		try {
			String str = "select * from vip";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			rs.last();
			ans = rs.getRow();
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ans;
	}

	// 将会员信息存入二维数组
	public String[][] vipData() {
		datamain = new Database();
		int a = datamain.getVipNum();
		String[][] data = new String[a][9];
		int i = 0;
		try {
			String str = "select * from vip  ";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			while (rs.next()) {
				data[i][0] = rs.getString("vid");
				data[i][1] = rs.getString("vname");
				data[i][2] = rs.getString("vsex");
				data[i][3] = rs.getString("vidcard");
				data[i][4] = rs.getString("vpnum");
				data[i][5] = rs.getString("vmailbox");
				data[i][6] = rs.getString("vlevel");
				data[i][7] = rs.getString("vpoints");
				data[i][8] = rs.getString("fangwannum");
				i++;
			}
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int as = 0; as < a; as++) {
			for (int ad = 0; ad < 9; ad++) {
				System.out.printf(data[as][ad] + " ");
			}
			System.out.println("");
		}
		return data;
	}

	// 返回会员表中最后一行的vid
	public String vipLastId() {
		String id = null;
		try {
			String str = "select * from vip ";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(str);
			rs.last();
			id = rs.getString("vid");
			rs.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	// 将会员登记数据存入数据库
	public boolean vipCheckin(String id, String name, String sex,
			String idcard, String pnum, String mailbox, String level) {
		boolean res = false;
		String str = "insert into vip(vid,vname,vsex,vidcard,vpnum,vmailbox,vlevel,vpoints,fangwannum)values('"
				+ id
				+ "','"
				+ name
				+ "','"
				+ sex
				+ "','"
				+ idcard
				+ "','"
				+ pnum + "','" + mailbox + "','" + level + "',0,0)";
		Statement state;
		try {
			state = conn.createStatement();
			state.executeUpdate(str);
			state.close();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 删除登陆历史信息
	public boolean deletecheckin() {
		boolean res = false;
		String str = "delete from checkin";
		Statement state;
		try {
			state = conn.createStatement();
			state.executeUpdate(str);
			state.close();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 添加新员工****成功为true，失败为false
	public boolean addUser(String username, String password, String flag) {
		boolean res = false;
		String str = "insert into user(username,password,flag)values('"
				+ username + "','" + password + "','" + flag + "')";
		Statement state;
		try {
			state = conn.createStatement();
			state.executeUpdate(str);
			state.close();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 删除员工****成功为true，失败为false
	public boolean deleteUser(String username) {
		boolean res = false;
		String str = "delete from user where username='" + username + "'";
		Statement state;
		try {
			state = conn.createStatement();
			state.executeUpdate(str);
			state.close();
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
