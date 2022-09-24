package org.ga2.buna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.SpotDetail;

public class SpotDetailDAO extends SpotDetail {
	private static SpotDetailDAO sd_DAO = null;
	public static SpotDetailDAO getInstance() {
		if(sd_DAO == null) sd_DAO = new SpotDetailDAO();
		return sd_DAO;
	}
	
	public Connection getConnection() throws Exception{
		return ((DataSource)(new InitialContext().
				lookup("java:comp/env/jdbc/oracle"))).getConnection();
	}
	
	public ArrayList<SpotDetail> getSpot() {
		ArrayList<SpotDetail> spotlist = new ArrayList<SpotDetail>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from spotdetail";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SpotDetail sd = new SpotDetail();
				sd.setS_serialnum(rs.getString(1));
				sd.setS_name(rs.getString(2));
				spotlist.add(sd);
			}
			
			System.out.println("조회 성공");
		} catch (Exception e) {
			System.out.println("조회 실패");
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return spotlist;
	}
}
