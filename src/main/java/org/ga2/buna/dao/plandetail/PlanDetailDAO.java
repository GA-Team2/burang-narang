package org.ga2.buna.dao.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.tag.PopularTagMapper;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.ga2.buna.dto.plandetail.PlanJoinDTO;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
public class PlanDetailDAO {

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

        //        List<PlanJoinDTO> list = new ArrayList<>();
//
//        String sql = "SELECT P_ROWNUM as plan_rownum, P_TRIPDAY as plan_tripday,"
//                   + "       P_TRIPDATE as plan_tripdate, P_SPOTNAME as plan_spotname,"
//                   + "       M_NICKNAME as member_nickname, P_TITLE as plan_title,"
//                   + "       T_NAMELIST as tag_namelist, P_LIKE as plan_like,"
//                   + "       S_SERIALNUM as spot_serialnum, P_SEQUENCE as plan_sequence,"
//                   + "       LOCATION as spot_location, PNUMBER as spot_number, E_NAME as event_name"
//                   + " FROM PLANDETAILVIEW WHERE P_ROWNUM = ?";
//
//        list = jdbcTemplate.query(sql, (rs, rowNum) -> {
//            PlanJoinDTO dto = new PlanJoinDTO();
//
//            dto.setPlanRownum(rs.getInt(1));
//            dto.setPlanTripday(rs.getInt(2));
//            dto.setPlanTripdate(rs.getString(3));
//            dto.setPlanSpotname(rs.getString(4));
//            dto.setMemberNickname(rs.getString(5));
//            dto.setPlanTitle(rs.getString(6));
//            dto.setTagNamelist(rs.getString(7));
//            dto.setPlanLike(rs.getInt(8));
//            dto.setSpotSerialnum(rs.getString(9));
//            dto.setPlanSequence(rs.getInt(10));
//            dto.setSpotLocation(rs.getString(11));
//            dto.setSpotNumber(rs.getString(12));
//            dto.setEventName(rs.getString(13));
//
//            return dto;
//        }, p_rownum);
//        return list;
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

    /**
     * 일자별 일정의 총 개수 구하는 메서드
     *
     * @param rownum:       플랜 번호
     * @return [totaltripday]크기만큼의 배열에 일자별 일정수를 담아서 리턴
     */

    public List<Integer> getTripDaySequence(int rownum) {
        log.info(planDetailMapper.getTripDaySequence(rownum).toString());
        return planDetailMapper.getTripDaySequence(rownum);
    }

    public List<SearchInfoDTO> getSearchInfo(int planRownum) {
        return planDetailMapper.getSearchInfo(planRownum);
    }
}
