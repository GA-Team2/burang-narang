package org.ga2.buna.dao.spot.traffic;

import java.util.List;

import javax.sql.DataSource;

import org.ga2.buna.dto.spot.traffic.TrafficDTO;

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
public class TrafficRepository {

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
	public List<TrafficDTO> selectAll() {
		String query = "SELECT * FROM TRAFFIC";

		List<TrafficDTO> trafficList = this.jdbcTemplate.query(query, (resultSet, rowNum) -> {
			TrafficDTO trafficDTO = new TrafficDTO();
			trafficDTO.setSpotSerialNumber(resultSet.getString(1));
			trafficDTO.setTrafficType(resultSet.getString(2));
			trafficDTO.setTrafficName(resultSet.getString(3));
			trafficDTO.setTrafficPhoneNumber(resultSet.getString(4));
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
	 * @param serialNumber 장소 고유 번호
	 * @return 교통 객체
	 *
	 */
	public TrafficDTO selectBySerialNumber(String serialNumber) {
		String query = "SELECT * FROM TRAFFIC WHERE S_SERIALNUM = ?";

		TrafficDTO trafficDTO = this.jdbcTemplate.queryForObject(query, (resultSet, rowNum) -> {
			TrafficDTO newTrafficDTO = new TrafficDTO();
			newTrafficDTO.setSpotSerialNumber(resultSet.getString(1));
			newTrafficDTO.setTrafficType(resultSet.getString(2));
			newTrafficDTO.setTrafficName(resultSet.getString(3));
			newTrafficDTO.setTrafficPhoneNumber(resultSet.getString(4));
			newTrafficDTO.setTrafficLocation(resultSet.getString(5));
			newTrafficDTO.setTrafficPhoto(resultSet.getString(6));

			return newTrafficDTO;
		}, serialNumber);

		log.debug(trafficDTO.toString());
		return trafficDTO;
	}
}