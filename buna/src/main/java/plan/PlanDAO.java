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
	 * 마이페이지 내 플랜 목록 얻어오는 메서드 - 최신순 정렬
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
				+ "		  P_REGDATE, P_LIKE, P_SHARE "
			    + "  FROM PLANINFO_TEST " 
				+ " WHERE M_NICKNAME=? "
				+ "ORDER BY P_FIRSTDATE DESC";
			
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
				planinfo.setP_like(rs.getInt("P_LIKE"));
				planinfo.setP_share(rs.getString("P_SHARE"));
				
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
	 * 플랜 삭제 메서드
	 * @param p_rownum : 플랜 고유번호
	 * @return
	 */
	public int deleteInfo (int p_rownum) throws Exception {
		int re = 0;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="";
		
		try {
			conn = getConnection();
			
			sql = "DELETE PLANINFO_TEST"
				+ " WHERE P_ROWNUM=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_rownum);
			re = pstmt.executeUpdate();
			
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
		
		return re;
	}
	
	/**
	 * 글 공개/비공개 업데이트 메서드
	 * 
	 * @param p_rownum : 플랜 고유 번호
	 * @param p_share  : 공유 여부
	 * @throws Exception
	 */
	public int shareUpdateInfo (int p_rownum, String p_share) throws Exception {
		int re=0;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="";
		
		try {
			conn = getConnection();
			
			//공유여부(p_share)가 N이면 Y로 변경
			if (p_share.equals("N")) {
				sql = "update planinfo_test"
						+ "   set p_share = 'Y'" 
						+ " where p_rownum = ?"
						+ "   and p_share = 'N'";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, p_rownum);
				pstmt.executeUpdate();
				re=1;   //플랜 공개
			} else {
				sql = "update planinfo_test"
						+ "   set p_share = 'N'" 
						+ " where p_rownum = ?"
						+ "   and p_share = 'Y'";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, p_rownum);
				pstmt.executeUpdate();
				re=2; 	//플랜 비공개
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
		
		return re;
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
			
			sql = "SELECT * "
				+ "  FROM (SELECT A.P_ROWNUM,"
				+ "               A.M_NICKNAME,"
				+ "               A.T_NAMELIST,"
				+ "               B.P_TRIPDAY,"
				+ "               B.P_TRIPDATE,"
				+ "               B.P_SPOTNAME"
				+ "          FROM PLANINFO_TEST A, PLANDETAIL_TEST B"
				+ "         WHERE A.P_ROWNUM = B.P_ROWNUM"
				+ "           AND M_NICKNAME = ?)"
				+ " WHERE P_ROWNUM = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_nickname);
			pstmt.setInt(2, p_rownum);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				PlanDetailDTO dto = new PlanDetailDTO();
				
				
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
	
	
	public int updateLikeNum (int p_rownum) throws Exception {
		int re = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			conn = getConnection();
			
			sql = "UPDATE PLANINFO_TEST"
			    + "   SET P_LIKE = P_LIKE+1" 
				+ " WHERE P_ROWNUM = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_rownum);
			re = pstmt.executeUpdate();
			
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
		
		return re;
	}
	
	
	/**
	 * 좋아요 수 얻어오는 메서드
	 * @param p_rownum
	 * @return
	 * @throws Exception
	 */
	public int getLikeNum (int p_rownum) throws Exception {
		int likeNum=0;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		
		try {
			conn = getConnection();
			
			sql = "SELECT P_LIKE"
			    + "  FROM PLANINFO_TEST" 
				+ " WHERE P_ROWNUM = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_rownum);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				PlanInfoDTO info = new PlanInfoDTO();
				
				info.setP_like(rs.getInt(1));
				
				likeNum = info.getP_like();
				System.out.println(likeNum);
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
