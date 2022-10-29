package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.planinfo.PlanInfoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePlanInfoImpl implements DeletePlanInfo {

    private final PlanInfoRepository planInfoDAO;

    @Override
    public void deletePlan(int rownum) {
        planInfoDAO.deletePlan(rownum);
    }
}
