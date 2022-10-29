package org.ga2.buna.dao.spot.accommodation;

import javax.sql.DataSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.spot.accommodation.AccommodationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 숙소에 접근하는 클래스
 * 
 * @author 한애채
 *
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class AccommodationRepository {

	private final AccommodationMapper accommodationMapper;

	/**
	 * 숙소 정보 리스트를 반환하는 메서드
	 *
	 * @return 숙소 객체 리스트
	 */
	public List<AccommodationDTO> selectAll() {
		return accommodationMapper.selectAll();
	}

	/**
	 * 시리얼 넘버를 변수로 받아 숙소 정보를 반환하는 메서드
	 * 
	 * @param serialNumber 장소 고유 번호
	 * @return 숙소 객체
	 *
	 */
	public AccommodationDTO selectBySerialNumber(String serialNumber) {
		return accommodationMapper.selectBySerialNumber(serialNumber);
	}
}
