package org.ga2.buna.service.makeplan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.planinfo.PlanInfoDAO;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SavePlanInfo {
    private final PlanInfoDAO planInfoDAO;

    public void save(PlanInfoDTO planInfoDTO) {
        planInfoDAO.insert(planInfoDTO);
    }
}