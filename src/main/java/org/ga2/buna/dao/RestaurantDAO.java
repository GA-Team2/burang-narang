package org.ga2.buna.dao;

import java.util.List;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.RestaurantDTO;
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
	 * 시리얼 넘버 변수를 통해 해당 맛집의 정보를 반환하는 클래스
	 * 
	 * @param 장소 고유 번호
	 * @return 맛집 객체
	 *
	 */
	/*public RestaurantDTO getRestaurant(String serialNum) {
		RestaurantDTO restaurant = new RestaurantDTO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from restaurant where s_serialnum=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, serialNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				restaurant.setSpotSerialNum(rs.getString(1));
				restaurant.setRestaurantType(rs.getString(2));
				restaurant.setRestaurantName(rs.getString(3));
				restaurant.setRestaurantPnumber(rs.getString(4));
				restaurant.setRestaurantLocation(rs.getString(5));
				restaurant.setRestaurantOpenTime(rs.getString(6));
				restaurant.setRestaurantCloseTime(rs.getString(7));
				restaurant.setRestaurantPhoto(rs.getString(8));
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

		return restaurant;
	}*/

	/**
	 * 맛집 DB 정보 반환하는 메서드
	 * 
	 * @return 맛집 객체 리스트
	 *
	 */
	public List<RestaurantDTO> getRestaurantList() {
		String query = "SELECT * FROM RESTAURANT";


		List<RestaurantDTO> restaurantDTOList = this.jdbcTemplate.query(query, (resultSet, rowNum) -> {
			RestaurantDTO restaurantDTO = new RestaurantDTO();
			restaurantDTO.setSpotSerialNum(resultSet.getString(1));
			restaurantDTO.setRestaurantType(resultSet.getString(2));
			restaurantDTO.setRestaurantName(resultSet.getString(3));
			restaurantDTO.setRestaurantPnumber(resultSet.getString(4));
			restaurantDTO.setRestaurantLocation(resultSet.getString(5));
			restaurantDTO.setRestaurantPhoto(resultSet.getString(6));

			return restaurantDTO;
		});

		log.debug(restaurantDTOList.toString());
		return restaurantDTOList;
	}
}