package org.ga2.buna.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.SpotDetailDTO;

/**
 * 장소 디테일 DB에 접근하는 클래스
 * 
 * @author 한애채
 *
 */
public class SpotDetailDAO extends SpotDetailDTO {
	private static SpotDetailDAO sd_DAO = null;

	public static SpotDetailDAO getInstance() {
		if (sd_DAO == null)
			sd_DAO = new SpotDetailDAO();
		return sd_DAO;
	}

	public Connection getConnection() throws Exception {
		return ((DataSource) (new InitialContext().lookup("java:comp/env/jdbc/mysql"))).getConnection();
	}

	/**
	 * 장소 이름을 변수로 받아 해당 이름이 장소 디테일에 존재한다면 장소 디테일의 정보를 반환하는 메서드
	 * 
	 * @param 장소 이름
	 * @return 장소 객체 리스트
	 *
	 */
	public ArrayList<SpotDetailDTO> getSpotList(String spotName) {
		ArrayList<SpotDetailDTO> spotList = new ArrayList<SpotDetailDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from spotDetail where s_name like ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + spotName + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				SpotDetailDTO spot = new SpotDetailDTO();
				spot.setSpotSerialNum(rs.getString(1));
				spot.setSpotName(rs.getString(2));
				spotList.add(spot);
			}

		} catch (Exception e) {
			System.out.println("조회 실패");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return spotList;
	}
}