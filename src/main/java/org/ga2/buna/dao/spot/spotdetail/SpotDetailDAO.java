package org.ga2.buna.dao.spot.spotdetail;

import java.util.List;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.spot.spotdetail.SpotDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 장소 디테일 DB에 접근하는 클래스
 * 
 * @author 한애채
 *
 */
@Slf4j
@Repository
public class SpotDetailDAO extends SpotDetailDTO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	/**
	 * 장소 이름을 변수로 받아 해당 이름이 장소 디테일에 존재한다면 장소 디테일의 정보를 반환하는 메서드
	 * 
	 * @param spotName 장소 이름
	 * @return 장소 객체 리스트
	 *
	 */
	public List<SpotDetailDTO> selectBySpotNameLike(String spotName) {
		String query = "SELECT S_SERIALNUM FROM SPOTDETAIL WHERE S_NAME LIKE ?";
		String param = "%" + spotName + "%";

		List<SpotDetailDTO> spotDetailDTOList = this.jdbcTemplate.query(query, (resultSet, rowNum) -> {
			SpotDetailDTO spotDetailDTO = new SpotDetailDTO();
			spotDetailDTO.setSpotSerialNumber(resultSet.getString(1));
			return spotDetailDTO;
		}, param);

		log.debug(spotDetailDTOList.toString());
		return spotDetailDTOList;
	}
}