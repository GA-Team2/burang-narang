package org.ga2.buna.service.editplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.plandetail.PlanDetailRepository;
import org.ga2.buna.dao.planinfo.PlanInfoRepository;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanInfo {
    private final PlanInfoRepository planInfoDAO;
    private final PlanDetailRepository planDetailDA0;

    public PlanInfoDTO findInByRowNumber(int rowNumber) {
        return planInfoDAO.selectByRowNumber(rowNumber);
    }
    public int getTotalTipDay(int rownNumber) {return planDetailDA0.getPlanDay(rownNumber);}
}
