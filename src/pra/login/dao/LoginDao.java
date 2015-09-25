package pra.login.dao;


import java.util.List;
import java.util.Map;

import pra.db.JdbcUtils;
import pra.login.service.LoginService;

public class LoginDao implements LoginService {

	private JdbcUtils jdbcUtils = null;

	public LoginDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	public int login(List<Object> params) {
		// TODO Auto-generated method stub
		boolean flag1 = false, flag2 = false;
		String sql1 = "select * from stu where id=? and psw=?";
		String sql2 = "select * from tec where tecid=? and tecpsw=?";
		try {
			params.get(0);
			jdbcUtils.getConnection();
			Map<String, Object> map1 = jdbcUtils.findSimpleResult(sql1, params);
			Map<String, Object> map2 = jdbcUtils.findSimpleResult(sql2, params);
			flag1 = !map1.isEmpty() ? true : false;
			flag2 = !map2.isEmpty() ? true : false;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		if (flag1 == true && flag2 == false)// 学生
			return 1;
		else if (flag1 == false && flag2 == true)// 老师
			return 2;
		else if (flag1 == false && flag2 == false) // 密码错
			return 0;
		else                     //数据库异常
			return 3;
	}

}
