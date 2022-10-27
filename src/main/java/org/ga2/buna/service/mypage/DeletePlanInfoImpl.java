package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.planinfo.PlanInfoDAO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePlanInfoImpl implements DeletePlanInfo {

    private final PlanInfoDAO planInfoDAO;

    @Override
    public void deletePlan(int rownum) {
        planInfoDAO.deletePlan(rownum);
    }
}
