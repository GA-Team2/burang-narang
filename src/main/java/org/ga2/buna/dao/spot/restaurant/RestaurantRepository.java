package org.ga2.buna.dao.spot.restaurant;

import java.util.List;

import javax.sql.DataSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.spot.restaurant.RestaurantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 맛집 정보에 접근하는 클래스
 * 
 * @author 한애채
 *
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class RestaurantRepository {

	private final RestaurantMapper restaurantMapper;

	/**
	 * 맛집 DB 정보 반환하는 메서드
	 * 
	 * @return 맛집 객체 리스트
	 *
	 */
	public List<RestaurantDTO> selectAll() {
		return restaurantMapper.selectAll();
	}

	/**
	 * 시리얼 넘버 변수를 통해 해당 맛집의 정보를 반환하는 클래스
	 *
	 * @param serialNumber 장소 고유 번호
	 * @return 맛집 객체
	 *
	 */
	public RestaurantDTO selectBySerialNumber(String serialNumber) {
		return restaurantMapper.selectBySerialNumber(serialNumber);
	}
}