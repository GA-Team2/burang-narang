package like;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import member.MemberDTO;
import plan.PlanInfoDTO;

public class LikeDAO {
	private static LikeDAO instance = new LikeDAO();
	
	public static LikeDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}


	/**
	 * info 테이블 좋아요 컬럼 수 증가
	 * @param p_rownum
	 * @return re==1이면 추천 완료
	 * @throws Exception
	 */
	public int updateLike (int rownum, Boolean likeTrue) throws Exception {
		int re = 0;
		int i=0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			conn = getConnection();
			
			if (likeTrue) {
				i=1;
			} else {
				i=-1;
			}
			
			sql = "UPDATE PLANINFO"
			    + "   SET P_LIKE = P_LIKE"+i
				+ " WHERE P_ROWNUM = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rownum);
			re=pstmt.executeUpdate();
			//업데이트 성공 시 re==1
			
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
	 * 좋아요 클릭시 좋아요 테이블에 닉네임+플랜 넘버를 추가
	 * @param member
	 * @param rownum
	 * @return
	 * @throws Exception
	 */
	public int insertLike (MemberDTO member, int rownum) throws Exception {
		
		int re=-1;		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		member = new MemberDTO();
		
		try {
			conn = getConnection();
						
			sql = "INSERT INTO LIKEINFO VALUES(?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getM_nickname());
			pstmt.setInt(2, rownum);
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int age = (member.getM_birthyear()-year)/10;
			pstmt.setInt(3, age);
			pstmt.setInt(4, member.getM_gender());
			
			re=pstmt.executeUpdate();
			//업데이트 성공 시 re==1
			
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
	 * 좋아요 여부 체크
	 * @param p_rownum
	 * @param nickname
	 * @return re==1 체크O / re==0 체크X
	 * @throws Exception
	 */
	public int checkLike (int rownum, String nickname) throws Exception {
		int re=-1;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		
		try {
			conn = getConnection();
			
			sql = "SELECT *"
			    + "  FROM LIKEINFO" 
				+ " WHERE P_ROWNUM = ? AND M_NICKNAME = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rownum);
			pstmt.setString(2, nickname);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				re=1; //좋아요 했음
			} else {
				re=0; //좋아요 안 함
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
		
		return re;
	}
	
	
	/**
	 * 추천 취소 메서드
	 * @param p_rownum
	 * @param nickname
	 * @return re==-1 취소 완료
	 * @throws Exception
	 */
	public int deleteLike (int rownum, String nickname) throws Exception {
		int re = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement deletePstmt = null;
		String sql = "";
		
		try {			
			sql = "DELETE "
				+ "  FROM LIKEINFO"
				+ " WHERE P_ROWNUM = ?"
				+ "   AND M_NICKNAME = ?";
			
			deletePstmt = conn.prepareStatement(sql);
			deletePstmt.setInt(1, rownum);
			deletePstmt.setString(2, nickname);
			deletePstmt.executeUpdate();
			
			re=-1; //취소 완료
			
			System.out.println("insert>>"+re);
			
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
			    + "  FROM PLANINFO" 
				+ " WHERE P_ROWNUM = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_rownum);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				PlanInfoDTO info = new PlanInfoDTO();
				
				info.setP_like(rs.getInt(1));
				
				likeNum = info.getP_like();
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
	
	
	
}