package pop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * 
 * @author 강승구
 *
 */
public class PopDAO {
	private static PopDAO instance = new PopDAO();
	
	/**
	 * 객체 생성
	 * @return PopDAO 객체
	 */
	public static PopDAO getInstance() {
		return instance;
	}
	
	/**
	 * db 연동
	 * @return 커넥션 객체
	 */
	public Connection getConnection() throws Exception{
		Context ctx = new InitialContext();
		DataSource ds =(DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	/**
	 * 인기플랜공유 페이지 내 게시판 목록 출력하는 메서드
	 * @param pageNumber 페이징처리
	 * @param likeClick 클릭시 추천순으로 정렬하는 쿼리
	 * @return 쿼리 결과값을 PopDTO에 넣고 ArrayList배열에 담아 리턴
	 */
	public ArrayList<PopDTO> listPop(String pageNumber, String likeClick) throws Exception{
		Connection con=null;
		Statement stmt = null; 
		ResultSet rs = null;
		ResultSet pageSet = null;
		int dbCount = 0;
		int absoultePage = 1;
		String sql = "";
		String sql2 = "";
		
		if(likeClick == null) {
			sql = "SELECT  P_ROWNUM , P_TITLE, T_NAMELIST,\r\n" + 
					"        P_REGDATE, P_LIKE FROM BOARDVIEW\r\n" + 
					"        ORDER BY P_ROWNUM DESC";
		} else if (likeClick.equals("true")) {
			sql = "SELECT  P_ROWNUM , P_TITLE, T_NAMELIST,\r\n" + 
					"        P_REGDATE, P_LIKE FROM BOARDVIEW\r\n" + 
					"        ORDER BY P_LIKE DESC";
		}
		
		sql2 = "SELECT COUNT(P_ROWNUM) FROM BOARDVIEW";
		
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
					} else {
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
	
	/**
	 * 인기플랜공유 페이지 내 상단부 TOP3 목록 출력하는 메서드
	 * @return 쿼리 결과값을 PopDTO에 넣고 ArrayList배열에 담아 리턴
	 */
	public ArrayList<PopDTO> listPop2() throws Exception{
		Connection con=null;
		Statement stmt = null; 
		ResultSet rs = null;
		String sql = "";
		
		sql = "SELECT B.* FROM (SELECT * FROM BOARDVIEW\r\n"  
			 +"       ORDER BY P_LIKE DESC) B WHERE ROWNUM <= 3";
		
		ArrayList<PopDTO> popList2 = new ArrayList<PopDTO>();
		
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
				
					popList2.add(pop); 
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
		return popList2;
	}
	
	/**
	 * 페이지 중간부분 인기 태그 출력하는 메서드
	 * @return 쿼리 결과값을 PopDTO에 넣고 ArrayList배열에 담아 리턴
	 */
	public ArrayList<PopDTO> listTag() throws Exception{
		Connection con=null;
		Statement stmt = null; 
		ResultSet rs = null;
		String sql = "";
		
		sql ="SELECT T.T_NAME, T.T_HIT FROM\r\n" + 
				 "       (SELECT * FROM TAGLIST\r\n" + 
				 "       ORDER BY T_HIT DESC) T\r\n" + 
				 "       WHERE ROWNUM <= 5";
		
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
