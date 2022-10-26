package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.planinfo.PlanInfoDAO;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SharePlanImpl implements SharePlan {

    private final PlanInfoDAO planInfoDAO;

    @Override
    public int publicUpdate(int rownum, int publicCheck) {
        log.debug("rownum => {}", rownum);
        log.debug("publicCheck => {}", publicCheck);

        int n = 0;

        if (publicCheck == 0) {
            n = 1;
        } else if (publicCheck == 1) {
            n = 0;
        }

        planInfoDAO.publicUpdateInfo(rownum, publicCheck, n);

        return n;
    }
}
