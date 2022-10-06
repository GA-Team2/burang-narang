package org.ga2.buna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.TagList;

/**
 * 태그 정보에 접근하는 클래스 => TagDAO와 병합 필요!!
 * @author 한에채
 *
 */
public class TagListDAO extends TagList {
	private static TagListDAO tl_DAO = null;
	public static TagListDAO getInstance() {
		if(tl_DAO == null) tl_DAO = new TagListDAO();
		return tl_DAO;
	}
	
	public Connection getConnection() throws Exception{
		return ((DataSource)(new InitialContext().
				lookup("java:comp/env/jdbc/oracle"))).getConnection();
	}
	
	/**
	 * 태그 이름 변수를 통해 태그 DB에 해당 태그가 존재하는지 결과를 반환하는 메서드
	 * @return re = 1 이면 태그가 존재, -1이면 존재하지 않음
	 *
	 */
	public int isTag(String tag) throws Exception {
		int re = -1;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select t_name from taglist where t_name=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tag);
			rs = pstmt.executeQuery();
			
			if (rs.next()) re = 1;
			else re = -1;

		}catch(SQLException ex){
			System.out.println("조회 실패");
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
	 * 태그 DB에 새롭게 입력된 태그 정보를 추가하는 메서드
	 * 새로운 태그가 추가되면서 태그 hit는 1로 초기화한다.
	 *
	 */
	public int insertTag(String tag) throws Exception {
		int re = -1;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into taglist values(?, ?)";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tag);
			pstmt.setInt(2, 1);
			
			re = pstmt.executeUpdate();

		}catch(SQLException ex){
			System.out.println("추가 실패");
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
	 * 태그 DB의 hit 컬럼을 업데이트하는 메서드
	 * 사용자가 플랜 작성 시 입력한 태그가 존재한다면 hit 컬럼만 업데이트한다.
	 *
	 */
	public int updateTag(String tag, Boolean b) throws Exception {
		int re=-1;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="update taglist set t_hit=t_hit+1 where t_name=?";
		if(b== false) sql="update taglist set t_hit=t_hit-1 where t_name=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tag);

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
	 * 태그 DB의 hit 컬럼을 내림차순으로 정렬한 결과를 반환하는 메서드
	 *
	 */
	public ArrayList<TagList> listTag() {
		String query = "SELECT T_NAME FROM TAGLIST ORDER BY T_HIT DESC";
		ArrayList<TagList> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				TagList td = new TagList();
				td.setT_name(rs.getString(1));
				list.add(td);
			}

			System.out.println("조회성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("조회실패");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	}
}
