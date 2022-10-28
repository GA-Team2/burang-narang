package org.ga2.buna.service.editplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.plandetail.PlanDetailDAO;
import org.ga2.buna.dao.planinfo.PlanInfoDAO;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanInfo {
    private final PlanInfoDAO planInfoDAO;
    private final PlanDetailDAO planDetailDA0;

    public PlanInfoDTO findInByRowNumber(int rowNumber) {
        return planInfoDAO.selectByRowNumber(rowNumber);
    }
    public int getTotalTipDay(int rownNumber) {return planDetailDA0.getPlanDay(rownNumber);}
}
