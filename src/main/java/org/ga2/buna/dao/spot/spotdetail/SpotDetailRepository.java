package org.ga2.buna.dao.spot.spotdetail;

import java.util.List;

import javax.sql.DataSource;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class SpotDetailRepository extends SpotDetailDTO {

	private final SpotDetailMapper spotDetailMapper;

	/**
	 * 장소 이름을 변수로 받아 해당 이름이 장소 디테일에 존재한다면 장소 디테일의 정보를 반환하는 메서드
	 * 
	 * @param spotName 장소 이름
	 * @return 장소 객체 리스트
	 *
	 */
	public List<SpotDetailDTO> selectBySpotNameLike(String spotName) {
		return spotDetailMapper.selectBySpotNameLike(spotName);
	}
}