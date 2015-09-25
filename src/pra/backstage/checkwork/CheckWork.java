package pra.backstage.checkwork;


import java.text.SimpleDateFormat;
import java.util.*;

import pra.db.*;
import pra.backstage.getmac.*;
import pra.backstage.macbook.*;

public class CheckWork {

	String ip1 = "192.168.1.";
	int ip2 = 108;
	int ip2Max = 118;
	String MacDefualt = "a8-15-4d-d9-e2-ee";

	JdbcUtils jdbcUtils;

	public CheckWork() {

	}

	/**
	 * 设定检查范围
	 * 
	 */
	public CheckWork(String ip1, int ip2, int ip2Max, String MacDefualt) {
		this.ip1 = ip1;
		this.ip2 = ip2;
		this.ip2Max = ip2Max;
		this.MacDefualt = MacDefualt;
	}

	/**
	 * 检查网络中实际mac地址
	 * @return List<String> String为mac地址集
	 */
	public List<String> CheckNet() {
		List<String> res = new ArrayList<String>();
		for (int i = ip2; i <= ip2Max; i++) {

			String mac = GetMac.getMacAddress(ip1 + i);
			if (!mac.equals(MacDefualt)) {
				System.out.println(mac);
				res.add(mac);
			}

		}
		System.out.println("CheckNet done");
		return res;
	}

	/**
	 * 返回所需要日期数据 格式：学年（例：20151）、星期几的第几节（例：24）
	 */
	public String[] GetDate() {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:EEEE:HH");
		String[] date = dateFormat.format(new Date()).split(":");

		String[] res = new String[2];

		int mm = Integer.parseInt(date[1]);
		int hh = Integer.parseInt(date[3]);

		if (mm > 8)
			res[0] = date[0] + "2";
		else
			res[0] = date[0] + "1";

		switch (date[2]) {
		case "星期一":
			res[1] = "1";
			break;
		case "星期二":
			res[1] = "2";
			break;
		case "星期三":
			res[1] = "3";
			break;
		case "星期四":
			res[1] = "4";
			break;
		case "星期五":
			res[1] = "5";
			break;
		case "星期六":
			res[1] = "6";
			break;
		case "星期七":
			res[1] = "7";
			break;
		}

		if (hh >= 8 && hh <= 10)
			res[1] += "1";
		else if (hh <= 12) {
			res[1] += "2";
		} else if (hh >= 14 && hh <= 16) {
			res[1] += "3";
		} else if (hh <= 18) {
			res[1] += "4";
		} else {
			return null;
		}
		System.out.println(res[0]);
		return res;
	}

	public MacBook CheckDb() {

		
		MacBook book = new MacBook();		
		
		String[] date = GetDate();
		System.out.println("date=" + date[0] + date[1]);
		
		if (date[0] == null)
			return null;

		jdbcUtils = new JdbcUtils();
		jdbcUtils.getConnection();

		// 取得应有MAC地址

		String sql = "select mac,no "
				+ "from stu natural join main "
				+ "where cyear = "+ date[0] + " and ctime = " + date[1];
		System.out.println(sql);

		try {
			List<mac> list=new ArrayList<mac>();
			list = jdbcUtils.findMoreRefResult(sql, null, mac.class);
			for (int i = 0; i < list.size(); i++) {
				book.add(list.get(i).getMac(),list.get(i).getNo());//装入理论mac值
				
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		} finally {

		}

		jdbcUtils.releaseConn();
		
		return book;
	}

	public static void main(String[] args) {
		CheckWork checkWork = new CheckWork();
		checkWork.CheckDb();

	}
}
