package festiver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAObean {
	private static DAObean instance = new DAObean();
		
	public static DAObean getInstance() {
		//호출하면 인스턴스 객체를 호출함. 해당되는 멤버를 사용할 수 있음
		return instance;
	}
		
	public Connection getConnection() throws Exception{ //throws 예외처리
		Context ctx = new InitialContext(); //dbcp 연동
		DataSource ds =(DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	public ArrayList<DTObean> listBoard(){
		// 리스트에 추가하는 메소드
		Connection con=null;
		Statement stmt = null; 
		ResultSet rs = null;
		//db정보 받기위해
		ArrayList<DTObean> ftlist = new ArrayList<DTObean>();
		
		try {
			con = getConnection();
			stmt = con.createStatement();
			String sql = "select * from event";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				DTObean  ft = new DTObean();
				ft.setE_id(rs.getInt(1));
				ft.setE_img(rs.getString(2));
				ft.setE_name(rs.getString(3));
				ft.setE_startdate(rs.getString(4));
				ft.setE_enddate(rs.getString(5));
				
				//값을 받아서 넣음.
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
