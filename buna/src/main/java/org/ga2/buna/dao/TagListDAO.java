package org.ga2.buna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.TagList;

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
	
	// tag 존재 유무 확인하는 메소드 
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
	
	// tag 추가 메서드
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
	
	// tag 업데이트 flase시 hit 삭제
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
