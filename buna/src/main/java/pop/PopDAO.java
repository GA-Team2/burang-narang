package pop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
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
	
	public ArrayList<PopDTO> listPop(String pageNumber, String likeClick) throws Exception{
		Connection con=null;
		Statement stmt = null; 
		ResultSet rs = null;
		ResultSet pageSet = null;
		int dbCount = 0;
		int absoultePage = 1;
		String sql = "";
		
		if(likeClick == null) {
			sql = "select * from boardView order by p_rownum desc";
		} else if (likeClick.equals("true")){
			sql = "select * from boardview order by p_like desc";
		}
		
		String sql2 = "select count(p_rownum) from boardview";
		
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
						pop.setP_rownum(rs.getInt(1));
						pop.setP_title(rs.getString(2));
						pop.setT_namelist(rs.getString(3));
						pop.setP_regdate(rs.getTimestamp(4));
						pop.setP_like(rs.getInt(5));
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
	
	public ArrayList<PopDTO> listPop() throws Exception{
		Connection con=null;
		Statement stmt = null; 
		ResultSet rs = null;
		
		String sql = "select b.*\r\n" + 
					"from (select * from boardview order by p_like desc) b\r\n" + 
					"where rownum<=3";
		
		ArrayList<PopDTO> popList = new ArrayList<PopDTO>();
		
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
				while (rs.next()) {
						PopDTO  pop = new PopDTO();
						pop.setP_rownum(rs.getInt(1));
						pop.setP_title(rs.getString(2));
						pop.setT_namelist(rs.getString(3));
						pop.setP_regdate(rs.getTimestamp(4));
						pop.setP_like(rs.getInt(5));
						popList.add(pop); 
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
	
	public ArrayList<PopDTO> listTag() throws Exception{
		Connection con=null;
		Statement stmt = null; 
		ResultSet rs = null;
		
		String sql ="select t.* from \r\n" + 
					"(select * from taglist\r\n" + 
					"order by t_hit desc) t\r\n" + 
					"where rownum<=5";
		
		ArrayList<PopDTO> tagList = new ArrayList<PopDTO>();
		
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
				while (rs.next()) {
						PopDTO  tag = new PopDTO();
						tag.setT_name(rs.getString(1));
						tag.setT_hit(rs.getInt(2));
						tagList.add(tag); 
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
		return tagList;
	}
}
