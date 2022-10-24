package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.PlanDAO;
import org.ga2.buna.dao.planinfo.PlanInfoDAO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Slf4j
@Service
@RequiredArgsConstructor
public class SharePlanImpl implements SharePlan {

    private final PlanInfoDAO planInfoDAO;

    @Override
    public void execute(Model model) {

        int rownum = Integer.parseInt(String.valueOf(model.getAttribute("rownum")));
        int publicCheck = Integer.parseInt(String.valueOf(model.getAttribute("shared")));
        log.info("rownum => {}", rownum);
        log.info("publicCheck => {}", publicCheck);

//        int publicCheck = planDAO.publicCheck(rownum);

        int n = 0;

        if (publicCheck == 0) {
            n = 1;
        } else if (publicCheck == 1) {
            n = 0;
        }

        planInfoDAO.publicUpdateInfo(rownum, publicCheck, n);
    }
}
