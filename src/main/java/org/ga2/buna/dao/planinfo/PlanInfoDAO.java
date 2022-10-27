package org.ga2.buna.dao.planinfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;

/**
 * 플랜 Info에 접근하는 클래스
 *
 * @author 한애채
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class PlanInfoDAO {
    private JdbcTemplate jdbcTemplate;
    private final PlanInfoMapper planInfoMapper;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    /**
     * 프랜 Info 정보를 insert하는 메서드
     *
     * @param planInfoDTO 디테일 객체
     */
    public void insert(PlanInfoDTO planInfoDTO) {
        String query = "SELECT MAX(P_ROWNUM) FROM PLANINFO";
        int maxRowNum = this.jdbcTemplate.queryForObject(query, Integer.class);

        query = "INSERT INTO planinfo VALUES(?,?,?,?,?,?,?,?,?)";

        int result = this.jdbcTemplate.update(query, maxRowNum + 1
                , planInfoDTO.getMemberNickName()
                , planInfoDTO.getPlanTitle()
                , planInfoDTO.getPlanFirstDate()
                , planInfoDTO.getPlanLastDate()
                , planInfoDTO.getTagNameList()
                , new Timestamp(System.currentTimeMillis())
                , 0
                , planInfoDTO.getPlanPublic());

        log.debug(planInfoDTO.toString());
        log.info("{}개 행 삽입 성공", result);
    }

    /**
     * 게시물 번호 변수를 통해 플랜 Info 정보를 반환하는 메서드
     *
     * @param rowNumber 게시물 번호
     * @return 플랜 인포 객체
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


    /**
     * 마이페이지 내 플랜 목록 얻어오는 메서드 -최신순 정렬
     *
     * @param m_nickname : 닉네임에 해당하는 planinfo테이블의 플랜 목록 모두 조회
     * @return PlanInfoDTO 객체를 담은 ArrayList를 리턴
     */
    public List<PlanInfoDTO> getPlanInfo(String m_nickname) {
        return planInfoMapper.getPlanInfo(m_nickname);
    }

    /**
     * 플랜번호에 해당하는 planinfo 테이블의 데이터 삭제하는 메서드
     *
     * @param p_rownum : 플랜 번호
     * @return re==1 삭제 성공
     */
    public int deletePlan(int p_rownum) {
        return planInfoMapper.deletePlan(p_rownum);
    }

    /**
     * 플랜 공개/비공개 업데이트 메서드
     *
     * @param p_rownum : 플랜 번호
     * @param p_public : 공개 여부 체크 / 0-비공개, 1-공개
     * @param n        : 비공개=-1 / 공개=1
     * @return
     */
    public void publicUpdateInfo(int p_rownum, int p_public, int n) {
/*        int re = 0;

        String sql = "UPDATE PLANINFO"
                + "   SET P_PUBLIC = ? "
                + " WHERE P_ROWNUM = ? "
                + "   AND P_PUBLIC = ? ";

        re = jdbcTemplate.update(sql, n, p_rownum, p_public);

        log.debug("업데이트 행수 = {}", re);
        log.debug("바뀐 공개여부 => 0이면 비공개 1이면 공개 => {}", n);*/
//        planInfoMapper.publicUpdateInfo(p_rownum, p_public, n);
    }
}
