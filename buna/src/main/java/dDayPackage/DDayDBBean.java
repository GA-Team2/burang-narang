package dDayPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DDayDBBean {
	private static DDayDBBean DDB = new DDayDBBean();
	
	public static DDayDBBean getInstance(){
		return DDB;
	}
	
	public Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	public DDayBean getDday(String nick) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DDayBean dDay = null;
		
		String sql = "SELECT CEIL(MIN(P_FIRSTDATE)-SYSDATE) AS D_DAY FROM PLANINFO WHERE M_NICKNAME=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nick);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dDay = new DDayBean();
				dDay.setdDay(Integer.parseInt(rs.getString(1)));
				dDay.setEmpty(rs.getString(1));
			}
		} catch (Exception ex) {
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
		return dDay;
	}
}
