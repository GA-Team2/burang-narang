package org.ga2.buna.dao;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.EventlistDTO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * @author 강승구
 *
 */
@Slf4j
public class EventlistDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
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
				
				evnet.setSpotSerialnum(rs.getString(1));
				evnet.setEventName(rs.getString(2));
				evnet.setEventLocation(rs.getString(3));
				evnet.setEventStartdate(rs.getTimestamp(4));
				evnet.setEventEnddate(rs.getTimestamp(5));
				evnet.setEventPhoto(rs.getString(6));
				evnet.setEventUrl(rs.getString(7));
				
				eventList.add(evnet);
			}
			
			log.info("조회 성공");
		} catch (Exception e) {
			log.info("조회 실패");
			e.printStackTrace();
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
