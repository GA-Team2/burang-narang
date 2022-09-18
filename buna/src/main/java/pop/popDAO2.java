package pop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class popDAO2 {
	private static popDAO2 instance = new popDAO2();
	
	public static popDAO2 getInstance() {
		//호출하면 인스턴스 객체를 호출함. 해당되는 멤버를 사용할 수 있음
		return instance;
	}
		
	public Connection getConnection() throws Exception{ //throws 예외처리
		Context ctx = new InitialContext(); //dbcp 연동
		DataSource ds =(DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	public ArrayList<popDTO2> listpop(){
		// 리스트에 추가하는 메소드
		Connection con=null;
		Statement stmt = null; 
		ResultSet rs = null;
		
		ArrayList<popDTO2> popList = new ArrayList<popDTO2>();
		
		try {
			con = getConnection();
			stmt = con.createStatement();
			String sql = "select * from board";
			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
					popDTO2  pop = new popDTO2();
					pop.setB_ROWNUM(rs.getInt(1));
					pop.setB_TITLE(rs.getString(2));
					pop.setB_HASHNAME(rs.getString(3));
					pop.setB_HASHHIT(rs.getInt(4));
					pop.setB_REGDATE(rs.getTimestamp(5));
					pop.setB_LIKE(rs.getInt(6));
					//값을 받아서 넣음.
					popList.add(pop); 
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
