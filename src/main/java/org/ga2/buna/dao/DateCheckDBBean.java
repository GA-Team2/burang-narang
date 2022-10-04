package org.ga2.buna.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.DateCheckBean;

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
		
		//조건에 맞은 닉네임의 MEMBERINFO 테이블 모든 칼럼 값을 가져오는 쿼리
		String sql = "SELECT * FROM DATECOUNT";
		
		ArrayList<DateCheckBean> gd = new ArrayList<DateCheckBean>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
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
		
		//필드 객체 생성자 리턴
		return gd;
	}
}