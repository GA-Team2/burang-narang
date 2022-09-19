package pop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class popDAO {
	private static popDAO instance = new popDAO();
	
	public static popDAO getInstance() {
		//호출하면 인스턴스 객체를 호출함. 해당되는 멤버를 사용할 수 있음
		return instance;
	}
		
	public Connection getConnection() throws Exception{ //throws 예외처리
		Context ctx = new InitialContext(); //dbcp 연동
		DataSource ds =(DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	public ArrayList<popDTO> listpop(String pageNumber) throws Exception{
		// 리스트에 추가하는 메소드
		Connection con=null;
		Statement stmt = null; 
		ResultSet rs = null;
		ResultSet pageSet = null; // 페이지번호를 받기위해
		int dbCount = 0; //페이지 번호의개수를 받기 위한 변수
		int absoultePage = 1; //출력할 페이지
		String sql = "select * from board";
		String sql2 = "select count(b_rownum) from board";
		
		ArrayList<popDTO> popList = new ArrayList<popDTO>();
		
		try {
			con = getConnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pageSet = stmt.executeQuery(sql2);
			
			if(pageSet.next()) { // dbcount에 총 개수를 넣음
				dbCount = pageSet.getInt(1);
				pageSet.close();
			}
			
			if(dbCount % popDTO.pageSize == 0) {//페이지 개수를 알려주기 위해
				//dbCount가 84, pageSize=10이라 가정 
				//8페이지하고 4개가 더 있기 때문에 else로 가서 9페이지가 나타남.
				popDTO.pageCount = dbCount / popDTO.pageSize;
			}else {
				popDTO.pageCount = dbCount / popDTO.pageSize + 1;
			}
			
			if(pageNumber != null) {
				popDTO.pageNum = Integer.parseInt(pageNumber);
				absoultePage = (popDTO.pageNum -1) * popDTO.pageSize +1;
				//페이지 
			}
			
//			stmt = con.createStatement();
			//총게시물의 개수를 구하는 쿼리
//			stmt = con.createStatement(); // 페이징처리할때 매개변수 2개짜리 사용
			// type_scroll_sensitive -> 스크롤할때 변경사항을 처리 
			//concur_updatatable -> 커서 위치에서 정보를업데이트한다.
			
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				rs.absolute(absoultePage); //stmt와 absoultePage를 공식처럼 사용함
				int count = 0;
				while (count<popDTO.pageSize) {
						popDTO  pop = new popDTO();
						pop.setB_ROWNUM(rs.getInt(1));
						pop.setB_TITLE(rs.getString(2));
						pop.setB_HASHNAME(rs.getString(3));
						pop.setB_HASHHIT(rs.getInt(4));
						pop.setB_REGDATE(rs.getTimestamp(5));
						pop.setB_LIKE(rs.getInt(6));
						//값을 받아서 넣음.
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
			System.out.println("조회 실패1");
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();	
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return popList;
	}
}
