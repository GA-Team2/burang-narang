package festiver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EventDAO {
	private static EventDAO instance = new EventDAO();
		
	public static EventDAO getInstance() {
		return instance;
	}
		
	public Connection getConnection() throws Exception{ 
		Context ctx = new InitialContext();
		DataSource ds =(DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	public ArrayList<EventDTO> listEvent(){
		Connection con=null;
		Statement stmt = null; 
		ResultSet rs = null;
		ArrayList<EventDTO> ftlist = new ArrayList<EventDTO>();
		
		try {
			con = getConnection();
			stmt = con.createStatement();
			String sql = "select * from event";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				EventDTO  ft = new EventDTO();
				ft.setS_serialnum(rs.getString(1));
				ft.setE_name(rs.getString(2));
				ft.setE_location(rs.getString(3));
				ft.setE_startdate(rs.getTimestamp(4));
				ft.setE_enddate(rs.getTimestamp(5));
				ft.setE_photo(rs.getString(6));
				ft.setE_url(rs.getString(7));
				ftlist.add(ft);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();	
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ftlist;
	}
}
