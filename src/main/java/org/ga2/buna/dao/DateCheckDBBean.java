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
	/* 
		DB에 등록된 날짜와 날짜마다의 일정카운트를 가져오는 메소드 
	*/
	public ArrayList<DateCheckBean> getDate() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//필드 객체 선언
		DateCheckBean date = null;
		
		//DATECOUNT VIEW의 데이터를 전부 가져오는 쿼리
		String sql = "SELECT * FROM DATECOUNT";
		//DTO객체를 담기위한 ArrayList 선언
		ArrayList<DateCheckBean> gd = new ArrayList<DateCheckBean>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//일정 전체의 날짜와 datecount를 DTO에 저장 후 배열에 추가
			while (rs.next()) {
				date = new DateCheckBean();
				//전체 날짜
				date.setP_tripdate(rs.getString(1));
				//날짜별 일정카운트
				date.setDatecount(rs.getInt(2));
				//ArrayList에 추가
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
		
		//ArrayList 배열 리턴
		return gd;
	}
}