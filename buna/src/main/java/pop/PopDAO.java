package pop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class PopDAO {
	private static PopDAO instance = new PopDAO();
	
	public static PopDAO getInstance() {
		return instance;
	}
		
	public Connection getConnection() throws Exception{
		Context ctx = new InitialContext();
		DataSource ds =(DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	public ArrayList<PopDTO> listPop(String pageNumber) throws Exception{
		Connection con=null;
		Statement stmt = null; 
		ResultSet rs = null;
		ResultSet pageSet = null;
		int dbCount = 0;
		int absoultePage = 1;
		String sql = "select * from board order by b_rownum desc";
		String sql2 = "select count(b_rownum) from board";
		
		ArrayList<PopDTO> popList = new ArrayList<PopDTO>();
		
		try {
			con = getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pageSet = stmt.executeQuery(sql2);
			
			if(pageSet.next()) {
				dbCount = pageSet.getInt(1);
				pageSet.close();
			}
			
			if(dbCount % PopDTO.pageSize == 0) {
				PopDTO.pageCount = dbCount / PopDTO.pageSize;
			}else {
				PopDTO.pageCount = dbCount / PopDTO.pageSize + 1;
			}
			
			if(pageNumber != null) {
				PopDTO.pageNum = Integer.parseInt(pageNumber);
				absoultePage = (PopDTO.pageNum -1) * PopDTO.pageSize +1;
			}
			
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				rs.absolute(absoultePage);
				int count = 0;
				while (count<PopDTO.pageSize) {
						PopDTO  pop = new PopDTO();
						pop.setB_ROWNUM(rs.getInt(1));
						pop.setB_TITLE(rs.getString(2));
						pop.setB_HASHNAME(rs.getString(3));
						pop.setB_HASHHIT(rs.getInt(4));
						pop.setB_REGDATE(rs.getTimestamp(5));
						pop.setB_LIKE(rs.getInt(6));
						popList.add(pop); 
						if(rs.isLast()) {
							break;
						}else {
							rs.next();
						}
					count++;
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();	
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return popList;
	}
}
