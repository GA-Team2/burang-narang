package org.ga2.buna.dao;

import org.ga2.buna.dto.EventlistDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * 이벤트에 접근하는 클래스 => eventListDAO와 병합 필요!!
 * 
 * @author 한애채
 *
 */
public class EventDAO extends EventlistDTO {
	private static EventDAO ev_DAO = null;

	public static EventDAO getInstance() {
		if (ev_DAO == null)
			ev_DAO = new EventDAO();
		return ev_DAO;
	}

	public Connection getConnection() throws Exception {
		return ((DataSource) (new InitialContext().lookup("java:comp/env/jdbc/mysql"))).getConnection();
	}

	/**
	 * 이벤트 정보 리스트를 반환하는 메서드
	 * 
	 * @return 이벤트 객체 리스트
	 *
	 */
	public ArrayList<EventlistDTO> getEvList() {
		ArrayList<EventlistDTO> evList = new ArrayList<EventlistDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from event";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EventlistDTO event = new EventlistDTO();

				event.setSpotSerialNum(rs.getString(1));
				event.setEventName(rs.getString(2));
				event.setEventVenue(rs.getString(3));
				event.setEventPnumber(rs.getString(4));
				event.setEventLocation(rs.getString(5));
				event.setEventStartDate(rs.getTimestamp(6));
				event.setEventEndDate(rs.getTimestamp(7));
				event.setEventPhoto(rs.getString(8));
				event.setEventUrl(rs.getString(9));

				evList.add(event);
			}
			System.out.println("조회 성공");
		} catch (Exception e) {
			System.out.println("조회 실패");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return evList;
	}

	/**
	 * 시리얼 넘버를 변수로 받아 이벤트 정보 반환하는 메서드
	 * 
	 * @param 장소 고유 번호
	 * @return 이벤트의 객체
	 *
	 */
	public EventlistDTO getEvent(String serialNum) {
		EventlistDTO event = new EventlistDTO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from event where s_serialnum=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, serialNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				event.setSpotSerialNum(rs.getString(1));
				event.setEventName(rs.getString(2));
				event.setEventVenue(rs.getString(3));
				event.setEventPnumber(rs.getString(4));
				event.setEventLocation(rs.getString(5));
				event.setEventStartDate(rs.getTimestamp(6));
				event.setEventEndDate(rs.getTimestamp(7));
				event.setEventPhoto(rs.getString(8));
				event.setEventUrl(rs.getString(9));
			}
			System.out.println("조회 성공");
		} catch (Exception e) {
			System.out.println("조회 실패");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return event;
	}
}