package org.ga2.buna.dao.spot.traffic;

import java.util.List;

import javax.sql.DataSource;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class TrafficRepository {

	private final TrafficMapper trafficMapper;

	/**
	 * 교통 정보 리스트를 반환하는 메서드
	 *
	 * @return 교통 객체 리스트
	 *
	 */
	public List<TrafficDTO> selectAll() {
		return trafficMapper.selectAll();
	}


	/**
	 * 시리얼 넘버 변수를 이용해 교통 정보를 반환하는 메서드
	 * 
	 * @param serialNumber 장소 고유 번호
	 * @return 교통 객체
	 *
	 */
	public TrafficDTO selectBySerialNumber(String serialNumber) {
		return trafficMapper.selectBySerialNumber(serialNumber);
	}
}