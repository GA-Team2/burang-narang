package org.ga2.buna.service.makeplan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.planinfo.PlanInfoRepository;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SavePlanInfo {
    private final PlanInfoRepository planInfoRepository;

    public void save(PlanInfoDTO planInfoDTO, int rowNumber) {
        planInfoRepository.insert(planInfoDTO, rowNumber);
    }

    public int maxByRowNumber() {
        return planInfoRepository.maxByRowNumber();
    }
}
