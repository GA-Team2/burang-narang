package plan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PlanDAO {
	private static PlanDAO instance=new PlanDAO();

	/**
	 * 전역 객체 생성
	 * @return PlanDAO 객체
	 */
	public static PlanDAO getInstance() {
		return instance;
	}
	
	/**
	 * db연결
	 * @return 커넥션 객체 생성
	 */
	public Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	
	/**
	 * 마이페이지 플랜 목록 얻어오는 메서드
	 * @param m_nickname : 닉네임을 이용해서 db에 저장된 플랜 목록 가져오기
	 * @return PlanInfoDTO 객체를 담은 ArrayList를 리턴받음
	 */
	public ArrayList<PlanInfoDTO> getPlanInfo(String m_nickname) throws Exception {	
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		
		ArrayList<PlanInfoDTO> planInfoList = new ArrayList<>();
		
		try {
			conn = getConnection();
			
			sql = "SELECT P_ROWNUM, M_NICKNAME, P_TITLE,"
				+ "       P_FIRSTDATE, P_LASTDATE, T_NAMELIST,"
				+ "		  P_REGDATE, P_LIKE"
			    + "  FROM PLANINFO_TEST" 
				+ " WHERE M_NICKNAME=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, 	m_nickname);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				PlanInfoDTO planinfo = new PlanInfoDTO();
				
				planinfo.setP_rownum(rs.getInt("P_ROWNUM"));
				//플랜 자세히 보기 페이지에 넘기기 위해 rownum값 받아오기
				planinfo.setP_title(rs.getString("P_TITLE"));
				planinfo.setP_firstdate(rs.getTimestamp("P_FIRSTDATE"));
				planinfo.setP_lastdate(rs.getTimestamp("P_LASTDATE"));
				planinfo.setT_namelist(rs.getString("T_NAMELIST"));
				planinfo.setP_regdate(rs.getTimestamp("P_REGDATE"));
				
				planInfoList.add(planinfo);
			}
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return planInfoList;
	}

	/**
	 * 디테일 페이지 정보 얻어오는 메서드 (미완성)
	 * @param 
	 * @return
	 */
	public ArrayList<PlanDetailDTO> getPlanDetail(String m_nickname, int p_rownum) throws Exception {	
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		
		ArrayList<PlanDetailDTO> planDetailList = new ArrayList<>();
		
		try {
			conn = getConnection();
			
			sql = "SELECT P_ROWNUM, P_TRIPDAY, S_SERIALNUM,"
				+ "       P_SPOTNAME, P_TRIPDATE, T_NAMELIST"
			    + "  FROM PLANDETAIL_TEST" 
				+ " WHERE P_ROWNUM=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_rownum);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				PlanDetailDTO plandetail = new PlanDetailDTO();
				
				
			}
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return planDetailList;
	}
	
	public int getLikeNum (int p_rownum) throws Exception {
		int likeNum=0;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		
		try {
			conn = getConnection();
			
			sql = "SELECT DISTINCT I.P_LIKE"
			    + "  FROM PLANDETAIL_TEST 'D', PLANINFO_TEST 'I'" 
				+ " WHERE D.P_ROWNUM = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_rownum);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				PlanInfoDTO info = new PlanInfoDTO();
				
				info.setP_like(rs.getInt(1));
				
			}
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return likeNum;
	}
	
	
} //DAO 끝
