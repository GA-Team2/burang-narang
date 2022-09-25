package festiver;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * 
 * @author 강승구
 *
 */
public class EventListDAO {
	private static EventListDAO instance = new EventListDAO();
		
	/**
	 * 객체 생성
	 * @return PopDAO 객체
	 */
	public static EventListDAO getInstance() {
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
	 * @return 쿼리 결과값을 EventListDTO에 넣고 ArrayList배열에 담아 리턴
	 */
	public ArrayList<EventListDTO> listEvent(){
		Connection con=null;
		Statement stmt = null; 
		ResultSet rs = null;
		String sql = "";
		
		sql = "SELECT S_SERIALNUM, E_NAME, E_VENUE, E_PNUMBER, E_LOCATION,\r\n" + 
				"     E_STARTDATE, E_ENDDATE, E_PHOTO, E_URL\r\n" + 
				"	  FROM EVENT WHERE E_STARTDATE IS NOT NULL \r\n" + 
				"     AND E_ENDDATE IS NOT NULL";
		
		ArrayList<EventListDTO> eventList = new ArrayList<EventListDTO>();
		
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				EventListDTO  event = new EventListDTO();
				
				event.setS_serialnum(rs.getString(1));
				event.setE_name(rs.getString(2));
				event.setE_venue(rs.getString(3));
				event.setE_location(rs.getString(4));
				event.setE_pnumber(rs.getString(5));
				event.setE_startdate(rs.getTimestamp(6));
				event.setE_enddate(rs.getTimestamp(7));
				event.setE_photo(rs.getString(8));
				event.setE_url(rs.getString(9));
				
				eventList.add(event);
			}
		} catch (Exception e) {
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
