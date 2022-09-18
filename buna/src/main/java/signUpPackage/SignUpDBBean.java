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
	
	public static SignUpDBBean getInstance() {
		return SDB;
	}
	
	public Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	public int insertMember(SignUpBean member) throws Exception{
		int re = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuffer insertQuery = new StringBuffer();
		
		insertQuery.append("insert into MEMBERINFO values(?,?,?,?,sysdate,?)");
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(insertQuery.toString());
			pstmt.setString(1, member.getM_nickname());
			pstmt.setString(2, member.getM_password());
			pstmt.setInt(3, member.getM_birthyear());
			pstmt.setInt(4, member.getM_gender());
			pstmt.setTimestamp(5, member.getM_joindate());
			pstmt.executeUpdate();
			
			re = 1;
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
		return re;
	}
	
	public int confirmID(String id) throws Exception{
		int re = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer searchQuery = new StringBuffer();
		try {
			conn = getConnection();
			searchQuery.append("select m_nickname from MEMBERINFO where m_nickname = ?");
			pstmt = conn.prepareStatement(searchQuery.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				re = 1;
			} else {
				re = -1;
			}
			
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
	
	public int userCheck(String id, String pwd) throws Exception{
		int re = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select m_password from MEMBERINFO where m_nickname = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String ax = rs.getString("m_password");
				if (ax.equals(pwd)) {
					re = 1;
				} else {
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
	
	public SignUpBean getMember(String id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SignUpBean member = null;
		
		String sql = "select * from MEMBERINFO where m_nickname=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				member= new SignUpBean();
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
