package org.ga2.buna.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.ga2.buna.dto.plandetail.PlanJoinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * 플랜정보를 다루는 클래스
 * @author 장희정
 */
@Slf4j
@Repository
public class PlanDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * 마이페이지 내 플랜 목록 얻어오는 메서드 -최신순 정렬
	 * @param m_nickname : 닉네임에 해당하는 planinfo테이블의 플랜 목록 모두 조회
	 * @return PlanInfoDTO 객체를 담은 ArrayList를 리턴
	 */
	public List<PlanInfoDTO> getPlanInfo(String m_nickname) {


		String sql = "SELECT P_ROWNUM, M_NICKNAME, P_TITLE,"
				   + "       P_FIRSTDATE, P_LASTDATE, T_NAMELIST,"
				   + "       P_REGDATE, P_LIKE, P_PUBLIC "
				   + "  FROM PLANINFO "
				   + " WHERE M_NICKNAME = ? "
				   + "ORDER BY P_FIRSTDATE DESC";

		List<PlanInfoDTO> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			//rs에는 select 결과 테이블이 담겨있다.
			//rowNum은 select 결과 테이블의 행의 수로 rowNum만큼 반복한다.
			PlanInfoDTO planInfoDTO = new PlanInfoDTO();

			planInfoDTO.setPlanRowNumber(rs.getInt("p_rownum"));
			planInfoDTO.setMemberNickName(rs.getString("m_nickname"));
			planInfoDTO.setPlanTitle(rs.getString("p_title"));
			planInfoDTO.setPlanFirstDate(rs.getTimestamp("p_firstdate"));
			planInfoDTO.setPlanLastDate(rs.getTimestamp("p_lastdate"));
			planInfoDTO.setTagNameList(rs.getString("t_namelist"));
			planInfoDTO.setPlanPublic(rs.getInt("p_public"));

			return planInfoDTO;
		}, m_nickname);
		//nick은 ?에 들어갈 변수
		return list;
	}
/*

	*/
/**
	 * 플랜번호에 해당하는 planinfo 테이블의 데이터 삭제하는 메서드
	 * 
	 * @param p_rownum : 플랜 번호
	 * @return re==1 삭제 성공
	 */


	public int deletePlan(int p_rownum) {
		String sql = "DELETE FROM PLANINFO WHERE P_ROWNUM = ? ";
		int re = 0;

		re = jdbcTemplate.update(sql, p_rownum);

		return re;
	}

	/**
	 *
	 * @param rownum
	 * @return
	 */
	public int publicCheck(int rownum) {

		String sql = "SELECT P_PUBLIC FROM PLANINFO WHERE P_ROWNUM = ?";
		int pub = jdbcTemplate.queryForObject(sql, Integer.class, rownum);

		log.info("공개여부조회 = {}", pub);
		return pub;
	}



	/**
	 * 플랜 공개/비공개 업데이트 메서드
	 * @param p_rownum : 플랜 번호
	 * @param p_public : 공개 여부 체크 / 0-비공개, 1-공개
	 * @param n : 비공개=-1 / 공개=1
	 * @return
	 */
	public void publicUpdateInfo(int p_rownum, int p_public, int n) {
		int re = 0;

		String sql = "UPDATE PLANINFO"
				   + "   SET P_PUBLIC = ? "
				   + " WHERE P_ROWNUM = ? "
				   + "   AND P_PUBLIC = ? ";

		re = jdbcTemplate.update(sql, n, p_rownum, p_public);

		log.info("업데이트 행수 = {}", re);
	}


	/**
	 * 디테일 페이지에 필요한 정보 얻어오는 메서드
	 * 
	 * @param p_rownum:플랜 번호
	 * @return planJoinDTO객체를 담은 arraylist
	 */

	public List<PlanJoinDTO> getPlanDetail(int p_rownum) {
		List<PlanJoinDTO> list = new ArrayList<>();

		String sql = "SELECT * FROM PLANDETAILVIEW WHERE P_ROWNUM = ?";

		list = jdbcTemplate.query(sql, (rs, rowNum) -> {
					PlanJoinDTO dto = new PlanJoinDTO();

					dto.setPlanRownum(rs.getInt(1));
					dto.setPlanTripday(rs.getInt(2));
					dto.setPlanTripdate(rs.getString(3));
					dto.setPlanSpotname(rs.getString(4));
					dto.setMemberNickname(rs.getString(5));
					dto.setPlanTitle(rs.getString(6));
					dto.setTagNamelist(rs.getString(7));
					dto.setPlanLike(rs.getInt(8));
					dto.setSpotSerialnum(rs.getString(9));
					dto.setPlanSequence(rs.getInt(10));
					dto.setSpotLocation(rs.getString(11));
					dto.setSpotNumber(rs.getString(12));
					dto.setEventName(rs.getString(13));

					return dto;
				}, p_rownum);
		return list;
	}

	public List<SearchInfoDTO> getSearchInfo(int planRownum) {
		String sql = "SELECT P_SPOTNAME, LOCATION, PNUMBER FROM PLANDETAILVIEW WHERE P_ROWNUM = ?";

		List<SearchInfoDTO> list = jdbcTemplate.query(sql, (resultSet, rowNum) -> {
			SearchInfoDTO searchInfo = new SearchInfoDTO();
			searchInfo.setPlanSpotname(resultSet.getString(1));
			searchInfo.setSpotLocation(resultSet.getString(2));
			searchInfo.setSpotPhoneNumber(resultSet.getString(3));
			return searchInfo;
		}, planRownum);

		return list;
	}

	/**
	 * 플랜 번호를 조건으로 전체 여행일 구하는 메서드
	 * 
	 * @param p_rownum 플랜번호
	 * @return totaltripday -> MAX(P_TRIPDAY)를 조회하여 해당 플랜의 최대 여행일을 리턴
	 */

	public int getPlanDay(int p_rownum) {

		String sql = "SELECT MAX(P_TRIPDAY) FROM PLANDETAIL WHERE P_ROWNUM = ? ";
		int totaltripday = jdbcTemplate.queryForObject(sql, Integer.class, p_rownum);

		log.info("전체 여행 일자 수 = {}", totaltripday);
		return totaltripday;
	}

	/**
	 * 일자별 일정의 총 개수 구하는 메서드
	 * 
	 * @param totaltripday: 전체 여행일(getPlanDay()의 리턴값)
	 * @param rownum:       플랜 번호
	 * @return [totaltripday]크기만큼의 배열에 일자별 일정수를 담아서 리턴
	 */

	public int[] getTripDaySequence(int totaltripday, int rownum) {

		int[] array = new int[totaltripday];

		String sql = "SELECT COUNT(*) "
				   + "  FROM PLANDETAIL "
				   + "GROUP BY P_TRIPDAY, P_ROWNUM "
				   + "HAVING P_ROWNUM = ?";

		jdbcTemplate.query(sql, (rs, rowNum) -> {
			array[rowNum] = rs.getInt(1);
			return array;
		}, rownum);

		return array;
	}
} // DAO 끝