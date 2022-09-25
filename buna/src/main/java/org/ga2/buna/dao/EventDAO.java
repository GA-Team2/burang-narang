package org.ga2.buna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.EventDTO;

public class EventDAO extends EventDTO {
	private static EventDAO ev_DAO = null;
	public static EventDAO getInstance() {
		if(ev_DAO == null) ev_DAO = new EventDAO();
		return ev_DAO;
	}
	
	public Connection getConnection() throws Exception{
		return ((DataSource)(new InitialContext().
				lookup("java:comp/env/jdbc/oracle"))).getConnection();
	}
	
	
	// 관광지 리스트 반환하는 메서드
	public ArrayList<EventDTO> getEvList(){
		ArrayList<EventDTO> evList = new ArrayList<EventDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from event";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EventDTO event = new EventDTO();
				
				event.setS_serialnum(rs.getString(1));
				event.setE_name(rs.getString(2));
				event.setE_venue(rs.getString(3));
				event.setE_location(rs.getString(4));
				event.setE_pnumber(rs.getString(5));
				event.setE_startdate(rs.getTimestamp(6));
				event.setE_enddate(rs.getTimestamp(7));
				event.setE_photo(rs.getString(8));
				event.setE_url(rs.getString(9));
				
				evList.add(event);
			}
		} catch (Exception e) {
			System.out.println("조회 실패");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return evList;
	}
	
	
	// 시리얼 넘버로 숙소 조회하는 메서드 
	public EventDTO getEvent(String serialNum) {
		EventDTO event = new EventDTO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from event where s_serialnum=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, serialNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				event.setS_serialnum(rs.getString(1));
				event.setE_name(rs.getString(2));
				event.setE_venue(rs.getString(3));
				event.setE_location(rs.getString(4));
				event.setE_pnumber(rs.getString(5));
				event.setE_startdate(rs.getTimestamp(6));
				event.setE_enddate(rs.getTimestamp(7));
				event.setE_photo(rs.getString(8));
				event.setE_url(rs.getString(9));
			}
		} catch (Exception e) {
			System.out.println("조회 실패");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return event;
	}
}
