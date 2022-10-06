package org.ga2.buna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.TrafficDTO;


/**
 * 교통 정보 접근 클래스
 * @author 한에채
 *
 */
public class TrafficDAO extends TrafficDTO {
	private static TrafficDAO tf_DAO = null;
	public static TrafficDAO getInstance() {
		if(tf_DAO == null) tf_DAO = new TrafficDAO();
		return tf_DAO;
	}

	public Connection getConnection() throws Exception{
		return ((DataSource)(new InitialContext().
				lookup("java:comp/env/jdbc/oracle"))).getConnection();
	}

	
	/**
	 * 시리얼 넘버 변수를 이용해 교통 정보를 반환하는 메서드
	 *
	 */
	public TrafficDAO getTraffic(String serialNum) {
		TrafficDAO traffic = new TrafficDAO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from traffic where s_serialnum=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, serialNum);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				traffic.setS_serialnum(rs.getString(1));
				traffic.setTf_type(rs.getString(2));
				traffic.setTf_name(rs.getString(3));
				traffic.setTf_pnumber(rs.getString(4));
				traffic.setTf_location(rs.getString(5));
				traffic.setTf_photo(rs.getString(6));
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

		return traffic;
	}


	/**
	 * 교통 정보 리스트를 반환하는 메서드
	 *
	 */
	public ArrayList<TrafficDTO> getTfList(){
		ArrayList<TrafficDTO> tfList = new ArrayList<TrafficDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from traffic order by s_serialnum";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				TrafficDTO traffic = new TrafficDTO();

				traffic.setS_serialnum(rs.getString(1));
				traffic.setTf_type(rs.getString(2));
				traffic.setTf_name(rs.getString(3));
				traffic.setTf_pnumber(rs.getString(4));
				traffic.setTf_location(rs.getString(5));
				traffic.setTf_photo(rs.getString(6));

				tfList.add(traffic);
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

		return tfList;
	}
}