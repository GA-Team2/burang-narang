package org.ga2.buna.dao;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.EventlistDTO;

/**
 * 
 * @author 강승구
 *
 */
public class EventlistDAO {
	private static EventlistDAO instance = new EventlistDAO();
		
	/**
	 * 객체 생성
	 * @return PopDAO 객체
	 */
	public static EventlistDAO getInstance() {
		return instance;
	}
	
	/**
	 * db 연동
	 * @return 커넥션 객체
	 */
	public Connection getConnection() throws Exception{ 
		Context ctx = new InitialContext();
		DataSource ds =(DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	/**
	 * 축제/이벤트 페이지 목록 출력 메서드
	 * @return 쿼리 결과값을 EventDTO에 넣고 ArrayList배열에 담아 리턴
	 */
	public ArrayList<EventlistDTO> listEvent(){
		Connection con=null;
		Statement stmt = null; 
		ResultSet rs = null;
		String sql = "";
		
		sql = "SELECT S_SERIALNUM, E_NAME, E_LOCATION, E_STARTDATE,\r\n" + 
			  "       E_ENDDATE, E_PHOTO, E_URL \r\n" + 
			  "       FROM EVENT WHERE E_STARTDATE IS NOT NULL \r\n" + 
			  "       AND E_ENDDATE IS NOT NULL";
		
		ArrayList<EventlistDTO> eventList = new ArrayList<EventlistDTO>();
		
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				EventlistDTO  evnet = new EventlistDTO();
				
				evnet.setS_serialnum(rs.getString(1));
				evnet.setE_name(rs.getString(2));
				evnet.setE_location(rs.getString(3));
				evnet.setE_startdate(rs.getTimestamp(4));
				evnet.setE_enddate(rs.getTimestamp(5));
				evnet.setE_photo(rs.getString(6));
				evnet.setE_url(rs.getString(7));
				
				eventList.add(evnet);
			}
			
			System.out.println("조회 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("조회 실패");
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();	
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return eventList;
	}
}
