package pra.backstage.listener;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pra.backstage.macbook.MacBook;
import pra.db.*;

public class UpdateBook  {

	private JdbcUtils jdbcUtils = null;

	public UpdateBook() {
		
		jdbcUtils = new JdbcUtils();
	}

	public void Update(MacBook book) {
		// TODO Auto-generated method stub
		String sql = "UPDATE main SET isabsence=? WHERE no = ? ";
		List<Object> params = new ArrayList<Object>();
		for(int i=0; i<book.size();i++){
			params.clear();
		params.add(book.get(i).getIsabsence());
		params.add(book.get(i).getNo());
		
		try {
			jdbcUtils.getConnection();
			jdbcUtils.updateByPreparedStatement(sql, params);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
			
		}
		
	}
	}
}
