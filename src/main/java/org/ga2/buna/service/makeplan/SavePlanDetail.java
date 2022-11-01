package org.ga2.buna.service.makeplan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.plandetail.PlanDetailRepository;
import org.ga2.buna.dao.planinfo.PlanInfoRepository;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 플랜 디테일 저장하는 클래스
 *
 * @author 한애채
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SavePlanDetail {
    private final PlanDetailRepository planDetailRepository;
    private final PlanInfoRepository planInfoRepository;

    /**
     * 플랜 디테일 리스트 저장하는 메서드
     *
     * @param planDetailDTOList 플랜 디테일 객체 리스트
     */
    public void saveAll(List<PlanDetailDTO> planDetailDTOList) {
        int rowNum = planInfoRepository.maxByRowNumber();

        for (PlanDetailDTO planDetailDTO : planDetailDTOList) {
            planDetailRepository.insert(planDetailDTO, rowNum);
        }
    }
}
