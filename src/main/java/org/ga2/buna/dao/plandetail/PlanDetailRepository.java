package org.ga2.buna.dao.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.ga2.buna.dto.plandetail.PlanJoinDTO;
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
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class PlanDetailRepository {

    private JdbcTemplate jdbcTemplate;
    private final PlanDetailMapper planDetailMapper;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


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

    /**
     * 플랜 Detail 객체와, 게시물 번호 변수를 받아 plandetail 정보를 insert하는 메서드
     *
     * @param planDetailDTO 플랜 디테일 객체
     * @param rowNumber     게시물 번호
     */
    public void insert(PlanDetailDTO planDetailDTO, int rowNumber) {

        String query = "INSERT INTO plandetail VALUES(?,?,?,?,?,?)";

        int result = this.jdbcTemplate.update(query, rowNumber
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


    /**
     * 디테일 페이지에 필요한 정보 얻어오는 메서드
     *
     * @param p_rownum:플랜 번호
     * @return planJoinDTO객체를 담은 arraylist
     */
    public List<PlanJoinDTO> getPlanDetail(int p_rownum) {
        return planDetailMapper.getPlanDetail(p_rownum);
    }

    /**
     * 플랜 번호를 조건으로 전체 여행일 구하는 메서드
     *
     * @param p_rownum 플랜번호
     * @return totaltripday -> MAX(P_TRIPDAY)를 조회하여 해당 플랜의 최대 여행일을 리턴
     */
    public int getPlanDay(int p_rownum) {
        return planDetailMapper.getPlanDay(p_rownum);
    }


    public List<SearchInfoDTO> getSearchInfo(int planRownum) {
        return planDetailMapper.getSearchInfo(planRownum);
    }
}
