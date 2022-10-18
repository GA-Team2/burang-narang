package org.ga2.buna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.ga2.buna.dto.TrafficDTO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 교통 정보 접근 클래스
 * 
 * @author 한애채
 *
 */
@Slf4j
@Repository
public class TrafficDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	/**
	 * 교통 정보 리스트를 반환하는 메서드
	 *
	 * @return 교통 객체 리스트
	 *
	 */
	public List<TrafficDTO> getTrafficList() {
		String query = "SELECT * FROM TRAFFIC ORDER BY S_SERIALNUM";

		List<TrafficDTO> trafficList = this.jdbcTemplate.query(query, (resultSet, rowNum) -> {
			TrafficDTO trafficDTO = new TrafficDTO();
			trafficDTO.setSpotSerialNum(resultSet.getString(1));
			trafficDTO.setTrafficType(resultSet.getString(2));
			trafficDTO.setTrafficName(resultSet.getString(3));
			trafficDTO.setTrafficPnumber(resultSet.getString(4));
			trafficDTO.setTrafficLocation(resultSet.getString(5));
			trafficDTO.setTrafficPhoto(resultSet.getString(6));

			return trafficDTO;
		});

		log.debug(trafficList.toString());
		return trafficList;
	}


	/**
	 * 시리얼 넘버 변수를 이용해 교통 정보를 반환하는 메서드
	 * 
	 * @param 장소 고유 번호
	 * @return 교통 객체
	 *
	 */
	/*public TrafficDAO getTraffic(String serialNum) {
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

			if (rs.next()) {
				traffic.setSpotSerialNum(rs.getString(1));
				traffic.setTrafficType(rs.getString(2));
				traffic.setTrafficName(rs.getString(3));
				traffic.setTrafficPnumber(rs.getString(4));
				traffic.setTrafficLocation(rs.getString(5));
				traffic.setTrafficPhoto(rs.getString(6));
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

		return traffic;
	}*/
}