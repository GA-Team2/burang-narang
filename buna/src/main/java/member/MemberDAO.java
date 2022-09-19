package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * 멤버 db관리를 위한 클래스
 * 
 * @author 장희정
 * 
 */
public class MemberDAO {
	private static MemberDAO instance=new MemberDAO();

	/**
	 * 전역 객체 생성
	 * @return MemberDAO 객체
	 */
	public static MemberDAO getInstance() {
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
	 * 닉네임 중복체크 메서드
	 * @param 유저가 입력한 nickname
	 * @return 중복값이 있으면 checkN=0, 없으면 1
	 */
	public int checkNickname(String nickname) throws Exception {
		int checkN=0;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql="SELECT M_NICKNAME FROM MEMBERINFO WHERE M_NICKNAME=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				checkN = 1; //중복
			} else {
				checkN = -1; //중복X 
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
		
		return checkN;
	}

	
	/**
	 * 회원 정보 업데이트 메서드
	 * @param MemberDTO 객체
	 * @return re = executeUpdate()
	 */
	public int updateMember(MemberDTO member, String nickname) throws Exception { 
		int re=-1;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="UPDATE MEMBERINFO"
				 + "   SET M_NICKNAME=?, M_PASSWORD=?"
				 + "	 , M_BIRTHYEAR=?, M_GENDER=?"
				 + " WHERE M_NICKNAME=?";
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getM_nickname());
			pstmt.setString(2, member.getM_password());
			pstmt.setInt(3, member.getM_birthyear());
			pstmt.setInt(4, member.getM_gender());
			pstmt.setString(5, nickname);
			
			re = pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("변경 실패");
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
	 * 회원 정보 삭제 메서드
	 * @param nickname : 로그인 했을 때 저장 된 닉네임값
	 * 		  password : 입력받은 password값
	 * @return executeUpdate() 리턴 값
	 */
	public int deleteMember(String nickname, String password) throws Exception { 
		int re=0;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		String pwd="";
		
		try {
			conn = getConnection();
			
			sql = "SELECT M_PASSWORD FROM MEMBERINFO WHERE M_NICKNAME=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				pwd = rs.getString(1);
				
				System.out.println(pwd);
				
				if (pwd.equals(password)) {
					sql = "DELETE FROM MEMBERINFO WHERE M_NICKNAME=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, nickname);
					re=pstmt.executeUpdate();
					re=1; //회원 정보 db 삭제 성공
				} else {
					re=0; //비밀번호 불일치
				}
			}
			System.out.println(re);
			
		}catch(SQLException ex){
			System.out.println("삭제 실패");
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
	 * 회원 정보 얻어오기 메서드
	 * @param nickname : 로그인 시 저장되는 닉네임값
	 * @return MemberDTO : memberDTO 객체를 리턴
	 */
	public MemberDTO getMember(String nickname) throws Exception {	
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		
		MemberDTO member=new MemberDTO();
		
		try {
			conn = getConnection();
			
			sql = "SELECT M_NICKNAME, M_PASSWORD, "
				+ "       M_BIRTHYEAR, M_GENDER, M_JOINDATE"
			    + "  FROM MEMBERINFO" 
				+ " WHERE M_NICKNAME=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {				
				member.setM_nickname(rs.getString(1));
				member.setM_password(rs.getString(2));
				member.setM_birthyear(rs.getInt(3));
				member.setM_gender(rs.getInt(4));
				member.setM_joindate(rs.getTimestamp(5));
			} else {
				
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
		return member;
	}
}
