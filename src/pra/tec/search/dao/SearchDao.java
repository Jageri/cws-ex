package pra.tec.search.dao;

import java.util.List;

import pra.db.JdbcUtils;
import pra.tec.search.service.*;
import pra.tec.table.*;

public class SearchDao implements SearchService {

	private JdbcUtils jdbcUtils = null;

	public SearchDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	public List<table> Search(List<Object> params) {
		// TODO Auto-generated method stub
System.out.println(params.get(0));
		String sql = "select id,name,cname,cno,tno,ctime,isabsence,no "
				+ "from tec natural join course natural join main natural join stu"
				+ " where tecid=? and cno=? and tno= ? and ctime=? ";
		try {
			jdbcUtils.getConnection();
			
			List<table> list = jdbcUtils.findMoreRefResult(sql, params, table.class);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return null;

	}

}
