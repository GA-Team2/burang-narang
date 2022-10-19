package org.ga2.buna.dao.spot.restaurant;

import java.util.List;

import javax.sql.DataSource;

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
public class RestaurantDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * 맛집 DB 정보 반환하는 메서드
	 * 
	 * @return 맛집 객체 리스트
	 *
	 */
	public List<RestaurantDTO> selectAll() {
		String query = "SELECT * FROM RESTAURANT";


		List<RestaurantDTO> restaurantDTOList = this.jdbcTemplate.query(query, (resultSet, rowNum) -> {
			RestaurantDTO restaurantDTO = new RestaurantDTO();
			restaurantDTO.setSpotSerialNumber(resultSet.getString(1));
			restaurantDTO.setRestaurantType(resultSet.getString(2));
			restaurantDTO.setRestaurantName(resultSet.getString(3));
			restaurantDTO.setRestaurantPhoneNumber(resultSet.getString(4));
			restaurantDTO.setRestaurantLocation(resultSet.getString(5));
			restaurantDTO.setRestaurantOpenTime(resultSet.getString(6));
			restaurantDTO.setRestaurantCloseTime(resultSet.getString(7));
			restaurantDTO.setRestaurantPhoto(resultSet.getString(8));

			return restaurantDTO;
		});

		log.debug(restaurantDTOList.toString());
		return restaurantDTOList;
	}

	/**
	 * 시리얼 넘버 변수를 통해 해당 맛집의 정보를 반환하는 클래스
	 *
	 * @param serialNumber 장소 고유 번호
	 * @return 맛집 객체
	 *
	 */
	public RestaurantDTO selectBySerialNumber(String serialNumber) {
		String query = "SELECT * FROM RESTAURANT WHERE S_SERIALNUM = ?";

		RestaurantDTO restaurantDTO = this.jdbcTemplate.queryForObject(query, (resultSet, rowNum) -> {
			RestaurantDTO newRestaurantDTO = new RestaurantDTO();
			newRestaurantDTO.setSpotSerialNumber(resultSet.getString(1));
			newRestaurantDTO.setRestaurantType(resultSet.getString(2));
			newRestaurantDTO.setRestaurantName(resultSet.getString(3));
			newRestaurantDTO.setRestaurantPhoneNumber(resultSet.getString(4));
			newRestaurantDTO.setRestaurantLocation(resultSet.getString(5));
			newRestaurantDTO.setRestaurantOpenTime(resultSet.getString(6));
			newRestaurantDTO.setRestaurantCloseTime(resultSet.getString(7));
			newRestaurantDTO.setRestaurantPhoto(resultSet.getString(8));

			return newRestaurantDTO;
		}, serialNumber);

		log.debug(restaurantDTO.toString());
		return restaurantDTO;
	}
}