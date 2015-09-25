package pra.stu.search.dao;

import java.util.List;
import java.util.Map;

import pra.db.JdbcUtils;
import pra.stu.search.service.*;

public class SearchDao implements SearchService {

	private JdbcUtils jdbcUtils = null;

	public SearchDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	public List<Map<String, Object>> Search(List<Object> params) {
		// TODO Auto-generated method stub

		String sql = "select cname ,ctime  "
				+ "from stu natural join main natural join course"
				+ " where id=? and " + "isabsence=1";

		try {
			jdbcUtils.getConnection();
			List<Map<String, Object>> map = jdbcUtils.findMoreResult(sql,
					params);
			return map;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return null;

	}

}
