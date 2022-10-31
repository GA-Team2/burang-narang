package org.ga2.buna.dao.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.ga2.buna.dto.plandetail.PlanJoinDTO;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;
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

    private final PlanDetailMapper planDetailMapper;

    /**
     * 게시물 번호를 변수로 받아 해당 게시물의 플랜 Detail 정보를 반환하는 메서드
     *
     * @param rowNumber 게시물 번호
     * @return 플랜 디테일 객체
     */
    public List<PlanDetailDTO> selectByRowNumber(int rowNumber) {
        return planDetailMapper.selectByRowNumber(rowNumber);
    }

    /**
     * 게시물 번호를 변수로 받아 해당 게시물의 플랜 Detail 정보를 반환하는 메서드
     *
     * @param planDetailDTO 플랜 디테일 객체
     * @return 플랜 디테일 객체
     */
    public PlanDetailDTO selectByRowNumberAndTripDayAndSequence(PlanDetailDTO planDetailDTO) {
        return planDetailMapper.selectByRowNumberAndTripDayAndSequence(planDetailDTO);
    }

    /**
     * 해당하는 날짜의 플랜이 존재하는지 검사하는 메서드
     *
     * @param planDetailDTO 플랜 디테일 객체
     * @return 존재하면 1, 아니면 0 반환
     */
    public Integer hasSequence(PlanDetailDTO planDetailDTO) {
        return planDetailMapper.hasSequence(planDetailDTO);
    }

    /**
     * 플랜 Detail 객체와, 게시물 번호 변수를 받아 plandetail 정보를 insert하는 메서드
     *
     * @param planDetailDTO 플랜 디테일 객체
     * @param rowNumber     게시물 번호
     */
    public void insert(PlanDetailDTO planDetailDTO, int rowNumber) {
        planDetailMapper.insert(planDetailDTO, rowNumber);
    }

    /**
     * 게시물 번호를 변수로 받아 해당 게시물의 플랜 Detail 정보를 삭제하는 메서드
     *
     * @param planDetailDTO 게시물 번호
     */
    public void delete(PlanDetailDTO planDetailDTO) {
        planDetailMapper.delete(planDetailDTO);
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
    public Integer getPlanDay(int p_rownum) {
        return planDetailMapper.getPlanDay(p_rownum);
    }


    public List<SearchInfoDTO> getSearchInfo(int planRownum) {
        return planDetailMapper.getSearchInfo(planRownum);
    }

    public void update(PlanDetailDTO planDetailDTO) {
        planDetailMapper.update(planDetailDTO);
    }
}
