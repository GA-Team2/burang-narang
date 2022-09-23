package dateCheckPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public DateCheckBean getDate(String year, int month) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//필드 객체 선언
		DateCheckBean date = null;
		
		//조건에 맞은 닉네임의 MEMBERINFO 테이블 모든 칼럼 값을 가져오는 쿼리
		String sql = "SELECT DATECOUNT, DAY FROM DATECOUNT WHERE YEAR=? AND MONTH=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, year);
			pstmt.setInt(2, month);
			rs = pstmt.executeQuery();
			
			date = new DateCheckBean();
			int date_temp[] = new int[31];
			if (rs.next()) {
				for (int i = 1; i < 32; i++) {
					if (i == Integer.parseInt(rs.getString("DAY"))) {
						date_temp[i] = rs.getInt("DATECOUNT");
					} else {
						date_temp[i] = 0;
					}
					rs.next();
				}
			}
			
			date.setDate(date_temp);
			
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
		
		//필드 객체 생성자 리턴
		return date;
	}
}
