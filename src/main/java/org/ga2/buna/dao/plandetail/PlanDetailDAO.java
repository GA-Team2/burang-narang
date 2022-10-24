package org.ga2.buna.dao.plandetail;

import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.sql.DataSource;

/**
 * 플랜 Detail에 접근하는 클래스
 * 
 * @author 한애채
 *
 */
@Slf4j
@Repository
public class PlanDetailDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);}


	/**
	 * 게시물 번호를 변수로 받아 해당 게시물의 플랜 Detail 정보를 반환하는 메서드
	 *
	 * @param rowNumber 게시물 번호
	 * @return 플랜 디테일 객체
	 */
	public List<PlanDetailDTO> selectByRowNumber(int rowNumber) {
		String query = "SELECT * FROM PLANDETAIL WHERE P_ROWNUM = ? ORDER BY P_TRIPDAY, P_SEQUENCE";

		List<PlanDetailDTO> planDetailDTOList = this.jdbcTemplate.query(query, (resultSet, rowNum) -> {
			PlanDetailDTO planDetailDTO = new PlanDetailDTO();
			planDetailDTO.setPlanRowNumber(resultSet.getInt(1));
			planDetailDTO.setPlanTripDay(resultSet.getInt(2));
			planDetailDTO.setPlanTripDate(resultSet.getTimestamp(3));
			planDetailDTO.setPlanSequence(resultSet.getInt(4));
			planDetailDTO.setSpotSerialNumber(resultSet.getString(5));
			planDetailDTO.setPlanSpotName(resultSet.getString(6));

			return planDetailDTO;
		}, rowNumber);

		log.debug(planDetailDTOList.toString());
		return planDetailDTOList;
	}

	public SearchInfoDTO selectSearchInfo(String spotname, String serialnum) {
		String query = "SELECT * FROM SEARCHSPOTINFOVIEW WHERE S_NAME = ? AND S_SERIALNUM = ?";

		SearchInfoDTO searchInfo = this.jdbcTemplate.queryForObject(query, (resultSet, rownum) -> {
			SearchInfoDTO newSearchInfo = new SearchInfoDTO();
			newSearchInfo.setPlanSpotname(resultSet.getString(1));
			newSearchInfo.setSpotLocation(resultSet.getString(3));
			newSearchInfo.setSpotPhoneNumber(resultSet.getString(4));
			return newSearchInfo;
		}, spotname, serialnum);

		log.debug(searchInfo.toString());
		return searchInfo;
	}

	/**
	 * 플랜 Detail 객체와, 게시물 번호 변수를 받아 plandetail 정보를 insert하는 메서드
	 *
	 * @param planDetailDTO 플랜 디테일 객체
	 */
	public void insert(PlanDetailDTO planDetailDTO) {
		int maxRowNum = this.jdbcTemplate.queryForObject("SELECT MAX(P_ROWNUM) FROM PLANDETAIL", Integer.class);


		String query = "INSERT INTO plandetail VALUES(?,?,?,?,?,?)";

		int result = this.jdbcTemplate.update(query, (maxRowNum + 1)
				, planDetailDTO.getPlanTripDay()
				, planDetailDTO.getPlanTripDate()
				, planDetailDTO.getPlanSequence()
				, planDetailDTO.getSpotSerialNumber()
				, planDetailDTO.getPlanSpotName());

		log.debug(planDetailDTO.toString());
		log.info("{}개 행 삽입 성공", result);
	}


	/**
	 * 게시물 번호를 변수로 받아 해당 게시물의 플랜 Detail 정보를 삭제하는 메서드
	 *
	 * @param rowNumber 게시물 번호
	 */
	public void delete(int rowNumber) {
		String query = "DELETE FROM PLANDETAIL WHERE P_ROWNUM = ?";

		int result = this.jdbcTemplate.update(query, rowNumber);

		log.info("rownum = {}인 {}개 행 삭제 성공", rowNumber, result);
	}
}
