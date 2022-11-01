package org.ga2.buna.service.makeplan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.planinfo.PlanInfoRepository;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.stereotype.Service;

/**
 * 플랜 인포 저장하는 메서드
 *
 * @author 한애채
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SavePlanInfo {
    private final PlanInfoRepository planInfoRepository;

    /**
     * 플랜 인포 저장하는 메서드
     *
     * @param planInfoDTO 플랜 인포 객체
     * @param rowNumber   게시물 번호
     */
    public void save(PlanInfoDTO planInfoDTO, int rowNumber) {
        planInfoRepository.insert(planInfoDTO, rowNumber);
    }

    /**
     * 게시물 번호의 최댓값을 받아오는 메서드
     *
     * @return 게시물 번호의 최댓값
     */
    public Integer maxByRowNumber() {
        return planInfoRepository.maxByRowNumber();
    }
}
