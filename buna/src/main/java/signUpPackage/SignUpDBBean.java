package signUpPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SignUpDBBean {
private static SignUpDBBean SDB = new SignUpDBBean();
	//signUpDBBean의 생성자를 리턴하는 getInstance()메소드 
	public static SignUpDBBean getInstance() {
		return SDB;
	}
	
	//DBCP기법으로 DB연결을 위한 메소드
	public Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	//회원 추가 메소드(매개변수로 필드 객체 선언)
	public int insertMember(SignUpBean member) throws Exception{
		//추가 성패 여부를 판단할 정수형 변수 re 선언 후 초기값 -1 설정
		int re = -1;
		
		//DB연결을 위한 객체
		Connection conn = null;
		//DB에 쿼리를 적용시켜주는 객체
		PreparedStatement pstmt = null;
		//문자열을 생성해주는 객체 선언
		StringBuffer insertQuery = new StringBuffer();
		
		//DB에 입력할 쿼리를 StringBuffer에 추가. MEMBERINFO에 회원정보를 추가하는 쿼리
		insertQuery.append("insert into MEMBERINFO values(?,?,?,?,sysdate)");
		
		try {
			//DBCP기법으로 DB연결
			conn = getConnection();
			//StringBuffer에 추가된 쿼리를 문자열 변수로 변환하고 DB에 적용
			pstmt = conn.prepareStatement(insertQuery.toString());
			//쿼리에 ?로 표시된 값에 값 추가
			pstmt.setString(1, member.getM_nickname());  //첫번째 ?에 필드에 입력된 닉네임 추가
			pstmt.setString(2, member.getM_password());  //두번째 ?에 필드에 입력된 패스워드 추가
			pstmt.setInt(3, member.getM_birthyear());  //세번째 ?에 필드에 입력된 탄생년도 추가
			pstmt.setInt(4, member.getM_gender());  //네번째 ?에 필드에 입력된 성별 추가
			//쿼리 업데이트
			pstmt.executeUpdate();
			
			//re값을 1로 재선언
			re = 1;
			
		//예외처리
		} catch(NamingException ne) {
			ne.printStackTrace();
		} catch(SQLException ex) {
			System.out.print("추가 실패.<br>");
			ex.printStackTrace();
		} finally {
			try{
				if (pstmt != null) pstmt.close();
				
				if(conn != null) conn.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//re값을 리턴
		return re;
	}
	
	//중복체크를 위한 메소드(매개변수 nick)
	public int confirmID(String nick) throws Exception{
		//중복 여부를 판단할 정수형 변수 re를 선언하고 -1로 초기화
		int re = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		//DB값을 저장할 ResultSet 객체 선언
		ResultSet rs = null;
		StringBuffer searchQuery = new StringBuffer();
		try {
			conn = getConnection();
			//MEMBERINFO 테이블에서 같은 닉네임을 찾는 쿼리
			searchQuery.append("select m_nickname from MEMBERINFO where m_nickname = ?");
			pstmt = conn.prepareStatement(searchQuery.toString());
			//첫번째 ?에 닉네임 값 설정
			pstmt.setString(1, nick);
			
			//쿼리로 찾은 값 저장
			rs = pstmt.executeQuery();
			if (rs.next()) {  //쿼리로 가져온 db에 값이 있는 경우
				//re값 1로 재선언
				re = 1;
			} else {
				re = -1;
			}
			//ResultSet 종료
			rs.close();
		} catch(SQLException ex) {
			System.out.println("추가실패");
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
		
		return re;
	}
	
	//로그인 시 회원 여부를 판단하는 메소드
	public int userCheck(String nick, String pwd) throws Exception{
		int re = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//MEMBERINFO 테이블에서 조건에 맞는 닉네임의 패스워드를 찾는 쿼리
		String sql = "select m_password from MEMBERINFO where m_nickname = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			//첫번째 ?에 닉네임 저장
			pstmt.setString(1, nick);
			rs = pstmt.executeQuery();
			if (rs.next()) {  //쿼리로 가져온 db에 값이 있는 경우
				//문자열 변수 ax에 ResultSet으로 받아온 값 중 m_password의 칼럼 값을 문자열 타입으로 받음
				String ax = rs.getString("m_password");
				if (ax.equals(pwd)) {  //ax에 저장된 패스워드 값이 매개변수로 입력된 패스워드의 값과 같을 경우
					re = 1;
				} else {  //다를 경우
					re = 0;
				}
			} else {
				re = -1;
			}
		} catch(SQLException ex) {
			System.out.println("인증실패");
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
		return re;
	}
	
	
	//회원정보를 가져오는 메소드
	public SignUpBean getMember(String nick) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//필드 객체 선언
		SignUpBean member = null;
		
		//조건에 맞은 닉네임의 MEMBERINFO 테이블 모든 칼럼 값을 가져오는 쿼리
		String sql = "select * from MEMBERINFO where m_nickname=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nick);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {  //쿼리로 가져온 db에 값이 있는 경우
				member= new SignUpBean();  //필드 객체를 선언한 member 변수에 생성자 선언
				
				//각 필드에 db로부터 가져온 값을 저장
				member.setM_nickname(rs.getString("m_nickname"));
				member.setM_password(rs.getString("m_password"));
				member.setM_birthyear(rs.getInt("m_birthyear"));
				member.setM_gender(rs.getInt("m_gender"));
				member.setM_joindate(rs.getTimestamp("m_joindate"));
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
		return member;
	}
	
	public int updateMember(SignUpBean member) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update MEMBERINFO set m_password=?, m_birthyear=?, m_gender=?";
		
		int re = -1;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getM_password());
			pstmt.setInt(2, member.getM_birthyear());
			pstmt.setInt(3, member.getM_gender());
			re = pstmt.executeUpdate();
			
			System.out.println("@@@### re ===>" + re);
			System.out.println("변경 성공");
		} catch(Exception e) {
			System.out.println("변경 실패");
			e.printStackTrace();
		}
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
		
		return re;
	}
}
