package org.ga2.buna.dao.spot.accommodation;

import javax.sql.DataSource;

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
public class AccommodationDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);}

	/**
	 * 숙소 정보 리스트를 반환하는 메서드
	 * 
	 * @return 숙소 객체 리스트
	 */
	public List<AccommodationDTO> selectAll() {
		String query = "SELECT * FROM ACCOMMODATION";

		List<AccommodationDTO> accommodationDTOList = this.jdbcTemplate.query(query, (resultSet, rowNum) -> {
			AccommodationDTO accommodationDTO = new AccommodationDTO();
			accommodationDTO.setSpotSerialNumber(resultSet.getString(1));
			accommodationDTO.setAccommodationType(resultSet.getString(2));
			accommodationDTO.setAccommodationName(resultSet.getString(3));
			accommodationDTO.setAccommodationPhoneNumber(resultSet.getString(4));
			accommodationDTO.setAccommodationLocation(resultSet.getString(5));
			accommodationDTO.setAccommodationCheckIn(resultSet.getString(6));
			accommodationDTO.setAccommodationCheckOut(resultSet.getString(7));
			accommodationDTO.setAccommodationPhoto(resultSet.getString(8));

			return accommodationDTO;
		});

		log.debug(accommodationDTOList.toString());
		return accommodationDTOList;
	}

	/**
	 * 시리얼 넘버를 변수로 받아 숙소 정보를 반환하는 메서드
	 * 
	 * @param serialNumber 장소 고유 번호
	 * @return 숙소 객체
	 *
	 */
	public AccommodationDTO selectBySerialNumber(String serialNumber) {
		String query = "SELECT * FROM ACCOMMODATION WHERE S_SERIALNUM = ?";

		AccommodationDTO accommodationDTO = this.jdbcTemplate.queryForObject(query, (resultSet, rowNum) -> {
			AccommodationDTO newAccommodationDTO = new AccommodationDTO();
			newAccommodationDTO.setSpotSerialNumber(resultSet.getString(1));
			newAccommodationDTO.setAccommodationType(resultSet.getString(2));
			newAccommodationDTO.setAccommodationName(resultSet.getString(3));
			newAccommodationDTO.setAccommodationPhoneNumber(resultSet.getString(4));
			newAccommodationDTO.setAccommodationLocation(resultSet.getString(5));
			newAccommodationDTO.setAccommodationCheckIn(resultSet.getString(6));
			newAccommodationDTO.setAccommodationCheckOut(resultSet.getString(7));
			newAccommodationDTO.setAccommodationPhoto(resultSet.getString(8));

			return newAccommodationDTO;
		}, serialNumber);

		log.debug(accommodationDTO.toString());
		return accommodationDTO;
	}
}
