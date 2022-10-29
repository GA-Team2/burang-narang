package org.ga2.buna.service.makeplan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.plandetail.PlanDetailRepository;
import org.ga2.buna.dao.planinfo.PlanInfoRepository;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SavePlanDetail {
    private final PlanDetailRepository planDetailDAO;
    private final PlanInfoRepository planInfoDAO;

    public void saveAll(List<PlanDetailDTO> planDetailDTOList) {
        int rowNum = planInfoDAO.maxByRowNumber();

        for (PlanDetailDTO planDetailDTO: planDetailDTOList) {
            planDetailDAO.insert(planDetailDTO, rowNum);
        }
    }
}
