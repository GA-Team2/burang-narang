package org.ga2.buna.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.DDayBean;


/**
 * 
 * D-day 기능을위한 클래스
 * @author 한병태
 * 
 */
@Slf4j
public class DDayDBBean {
	private static DDayDBBean DDB = new DDayDBBean();
	
	public static DDayDBBean getInstance(){
		return DDB;
	}
	
	public Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
		return ds.getConnection();
	}
	/**
	* 
	* D-day를 표시하기위한 일정 첫번째 날짜를 가져오기위한 메소드
	* @return DDayBean객체 획득
	*
	*/
	public DDayBean getDday(String nick) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//DTO 선언
		DDayBean dDay = null;
		//PLANINFO 테이블에서 접속한 유저의 일정 중 가장 빠른 날짜를 가져와 현재 날짜에서 뺀 값을 가져오는 쿼리 -> D-day까지 남은 일 수
		String sql = "SELECT CEIL(MIN(P_FIRSTDATE)-curdate()) AS D_DAY FROM PLANINFO WHERE M_NICKNAME=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nick);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dDay = new DDayBean();
				//남은 일 수 저장
				dDay.setDDay((rs.getInt(1)));
				//null포인터 에러 방지용
				dDay.setEmpty(rs.getString(1));
			}
		} catch (Exception ex) {
			log.info("탐색 실패");
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
		//DTO 리턴
		return dDay;
	}
}