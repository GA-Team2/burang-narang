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
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
		return ds.getConnection();
	}
	/**
	 * DB로부터 일정 날짜와 날짜별 일정 수를 가져오는 메소드
	 * @return ArrayList배열 획득
	 */
	public ArrayList<DateCheckBean> getDate() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//DTO 선언
		DateCheckBean date = null;

		
		//DATECOUNT VIEW의 모든 데이터를 가져오는 쿼리문
		String sql = "SELECT * FROM DATECOUNT";
		//DTO 객체를 타입으로 갖는 ArrayList 선언
		ArrayList<DateCheckBean> gd = new ArrayList<DateCheckBean>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//VIEW의 모든 데이터를 DTO에 저장 후 ArrayList배열에 넣는 반복문
			while (rs.next()) {
				date = new DateCheckBean();
				//일정 날짜
				date.setPlanTripdate(rs.getString(1));
				//날짜별 일정 수
				date.setDatecount(rs.getInt(2));
				//ArrayList배열에 추가
				gd.add(date);
			}
		} catch(SQLException ex) {
			System.out.println("조회실패");
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