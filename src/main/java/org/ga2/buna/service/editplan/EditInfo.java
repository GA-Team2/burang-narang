package org.ga2.buna.service.editplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.planinfo.PlanInfoRepository;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditInfo {
    private final PlanInfoRepository planInfoRepository;

    public void update(PlanInfoDTO planInfoDTO) {
        planInfoRepository.update(planInfoDTO);
    }
}
