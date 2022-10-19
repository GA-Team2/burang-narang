package org.ga2.buna.dao.planinfo;

import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * 플랜 Info에 접근하는 클래스
 * 
 * @author 한애채
 *
 */
@Slf4j
@Repository
public class PlanInfoDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);}


	/**
	 * 프랜 Info 정보를 insert하는 메서드
	 * 
	 * @param planInfoDTO 디테일 객체
	 *
	 */
	public void insert(PlanInfoDTO planInfoDTO) {
		String query = "SELECT MAX(P_ROWNUM) FROM PLANINFO";
		int maxRowNum = this.jdbcTemplate.queryForObject(query, Integer.class);

		query = "INSERT INTO planinfo VALUES(?,?,?,?,?,?,?,?,?)";

		int result = this.jdbcTemplate.update(query, maxRowNum+1
												, planInfoDTO.getMemberNickName()
												, planInfoDTO.getPlanTitle()
												, planInfoDTO.getPlanFirstDate()
												, planInfoDTO.getPlanLastDate()
												, planInfoDTO.getTagNameList()
												, planInfoDTO.getPlanRegisterDate()
												, 0
												, planInfoDTO.getPlanPublic());

		log.debug(planInfoDTO.toString());
		log.info("{}개 행 삽입 성공", result);
	}

	/**
	 * 게시물 번호 변수를 통해 플랜 Info 정보를 반환하는 메서드
	 * 
	 * @param  rowNumber 게시물 번호
	 * @return 플랜 인포 객체
	 *
	 */
	public PlanInfoDTO selectByRowNumber(int rowNumber) {
		String query = "SELECT P_TITLE, P_FIRSTDATE, P_LASTDATE, T_NAMELIST FROM PLANINFO WHERE P_ROWNUM = ?";

		PlanInfoDTO planInfoDTO = this.jdbcTemplate.queryForObject(query, (resultSet, rowNum) -> {
			PlanInfoDTO newPlanInfoDTO = new PlanInfoDTO();
			newPlanInfoDTO.setPlanTitle(resultSet.getString(1));
			newPlanInfoDTO.setPlanFirstDate(resultSet.getTimestamp(2));
			newPlanInfoDTO.setPlanLastDate(resultSet.getTimestamp(3));
			newPlanInfoDTO.setTagNameList(resultSet.getString(4));

			return newPlanInfoDTO;
		}, rowNumber);

		log.debug(planInfoDTO.toString());
		return planInfoDTO;
	}

	/**
	 * 플랜 Info 객체 변수로 받아 플랜 Info를 수정하는 메서드
	 * 
	 * @param planInfoDTO 플랜 인포 객체
	 *
	 */
	public void update(PlanInfoDTO planInfoDTO) {
		String query = "UPDATE PLANINFO SET P_TITLE = ?, P_FIRSTDATE = ?, P_LASTDATE = ?, T_NAMELIST = ?, P_PUBLIC = ? WHERE P_ROWNUM = ?";

		int result = this.jdbcTemplate.update(query, planInfoDTO.getPlanTitle()
												, planInfoDTO.getPlanFirstDate()
												, planInfoDTO.getPlanLastDate()
												, planInfoDTO.getTagNameList()
												, planInfoDTO.getPlanPublic()
												, planInfoDTO.getPlanRowNumber());

		log.debug(planInfoDTO.toString());
		log.info("{}개 행 수정 성공", result);
	}
}
