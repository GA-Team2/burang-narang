package org.ga2.buna.service.makeplan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.plandetail.PlanDetailDAO;
import org.ga2.buna.dao.planinfo.PlanInfoDAO;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SavePlanDetail {
    private final PlanDetailDAO planDetailDAO;
    private final PlanInfoDAO planInfoDAO;

    public void saveAll(List<PlanDetailDTO> planDetailDTOList) {
        int rowNum = planInfoDAO.maxByRowNumber();

        for (PlanDetailDTO planDetailDTO: planDetailDTOList) {
            planDetailDAO.insert(planDetailDTO, rowNum);
        }
    }
}
