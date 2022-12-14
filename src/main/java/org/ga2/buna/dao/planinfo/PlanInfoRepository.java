package org.ga2.buna.dao.planinfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 플랜 Info에 접근하는 클래스
 *
 * @author 장희정, 한애채
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class PlanInfoRepository {
    private final PlanInfoMapper planInfoMapper;

    /**
     * 플랜 Info 저장하는 메서드
     *
     * @param planInfoDTO 디테일 객체
     * @param rowNumber   플랜 번호
     */
    public void insert(PlanInfoDTO planInfoDTO, int rowNumber) {
        planInfoMapper.insert(planInfoDTO, rowNumber);
        log.debug("{} 저장 완료.", planInfoDTO.toString());
    }

    /**
     * 게시물 번호의 최댓값 반환하는 메서드
     *
     * @return 게시물 번호의 최댓값
     */
    public Integer maxByRowNumber() {
        log.debug(planInfoMapper.maxByRowNumber().toString());
        return planInfoMapper.maxByRowNumber();
    }

    /**
     * 해당하는 게시물 번호를 가지는 플랜 Info 객체 반환하는 메서드
     *
     * @param rowNumber 게시물 번호
     * @return 플랜 인포 객체
     */
    public PlanInfoDTO selectByRowNumber(int rowNumber) {
        return planInfoMapper.selectByRowNumber(rowNumber);
    }

    /**
     * 해당하는 플랜 Info를 수정하는 메서드
     *
     * @param planInfoDTO 플랜 인포 객체
     */
    public void update(PlanInfoDTO planInfoDTO) {
        planInfoMapper.update(planInfoDTO);
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
     * 해당 게시물 번호를 가지는 플랜 인포 데이터 삭제하는 메서드
     *
     * @param p_rownum : 플랜 번호
     */
    public void deletePlan(int p_rownum) {
        planInfoMapper.deletePlan(p_rownum);
    }

    /**
     * 플랜 공개/비공개 업데이트 메서드
     *
     * @param p_rownum : 플랜 번호
     * @param p_public : 공개 여부 체크 / 0-비공개, 1-공개
     * @param n        : 공개여부컬럼 업데이트할 변수 n / p_public이 0이면 n=1, 1이면 n=0
     * @return
     */
    public void publicUpdateInfo(int p_rownum, int p_public, int n) {
        planInfoMapper.publicUpdateInfo(p_rownum, p_public, n);
    }
}
