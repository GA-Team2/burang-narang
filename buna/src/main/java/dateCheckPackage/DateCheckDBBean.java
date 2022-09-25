package dateCheckPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DateCheckDBBean {
	private static DateCheckDBBean EDB = new DateCheckDBBean();
	
	public static DateCheckDBBean getInstance() {
		return EDB;
	}
	
	public Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	public ArrayList<DateCheckBean> getDate() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//필드 객체 선언
		DateCheckBean date = null;
		
		//DATECOUNT view의 데이터를 가져오는 쿼리
		String sql = "SELECT * FROM DATECOUNT";
		
		//DateCheckBean클래스를 매개로하는 ArrayList컬렉션 선언
		ArrayList<DateCheckBean> gd = new ArrayList<DateCheckBean>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//DATECOUNT view에서 데이터를 배열에 저장
			while (rs.next()) {
				date = new DateCheckBean();
				date.setP_tripdate(rs.getString(1));
				date.setDatecount(rs.getInt(2));
				gd.add(date);
			}
		} catch(SQLException ex) {
			System.out.println("탐색실패");
			ex.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//배열리턴
		return gd;
	}
}
