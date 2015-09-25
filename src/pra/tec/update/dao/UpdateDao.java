package pra.tec.update.dao;

import java.sql.SQLException;
import java.util.List;


import pra.db.JdbcUtils;
import pra.tec.update.service.*;


public class UpdateDao implements UpdateService {

	private JdbcUtils jdbcUtils = null;

	public UpdateDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	public boolean Update(List<Object> params) {
		// TODO Auto-generated method stub
		String sql = "UPDATE main SET isabsence='0' WHERE no = ? ";
		
		boolean flag =false;
		try {
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
			System.out.println(flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
			
		}
		return flag;
	}

}
