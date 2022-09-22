package editPlanDetailPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EditPlanDetailDBBean {
	private static EditPlanDetailDBBean EDB = new EditPlanDetailDBBean();
	
	public static EditPlanDetailDBBean getInstance() {
		return EDB;
	}
	
	public Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	public EditPlanDetailBean getMember(String nick) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//필드 객체 선언
		EditPlanDetailBean plan = null;
		
		//조건에 맞은 닉네임의 MEMBERINFO 테이블 모든 칼럼 값을 가져오는 쿼리
		String sql = "select * from plandetail where p_rownum = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nick);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {  //쿼리로 가져온 db에 값이 있는 경우
				plan= new EditPlanDetailBean();  //필드 객체를 선언한 member 변수에 생성자 선언
				
				//각 필드에 db로부터 가져온 값을 저장
				plan.setP_rownum(rs.getInt("p_rownum"));
				plan.setP_tripday(rs.getInt("p_tripday"));
				plan.setP_tripdate(rs.getTimestamp("p_tripdate"));
				plan.setP_sequence(rs.getInt("p_sequence"));
				plan.setP_serialnum(rs.getString("p_serialnum"));
				plan.setP_spotname(rs.getString("p_spotname"));
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
		
		//필드 객체 생성자 리턴
		return plan;
	}
}
