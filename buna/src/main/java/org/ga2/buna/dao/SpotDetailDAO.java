package org.ga2.buna.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.SpotDetailDTO;

public class SpotDetailDAO extends SpotDetailDTO {
	private static SpotDetailDAO sd_DAO = null;
	public static SpotDetailDAO getInstance() {
		if(sd_DAO == null) sd_DAO = new SpotDetailDAO();
		return sd_DAO;
	}
	
	public Connection getConnection() throws Exception{
		return ((DataSource)(new InitialContext().
				lookup("java:comp/env/jdbc/oracle"))).getConnection();
	}
	
	/*
	 검색 기능에 필요한 메서드
	 spot 이름 받아와 serial num 반환 
	*/
	public ArrayList<SpotDetailDTO> getSpotList(String spotName) {
		ArrayList<SpotDetailDTO> spotList = new ArrayList<SpotDetailDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from spotdetail where s_name=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, spotName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SpotDetailDTO spot = new SpotDetailDTO();
				spot.setS_serialnum(rs.getString(1));
				spot.setS_name(rs.getString(2));
				spotList.add(spot);
			}
			
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
		
		return spotList;
	}
}
