package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.PlanDAO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Slf4j
@Service
@RequiredArgsConstructor
public class SharePlanImpl implements SharePlan{

    private final PlanDAO planDAO;

    @Override
    public void execute(Model model) {

        int rownum = (int) model.getAttribute("rownum");
        log.info("rownum = "+rownum);
        int pub = planDAO.publicCheck(rownum);
        log.info("pub = " + pub);
        int n = 0;

        if (pub == 1) {
            n = -1;
        } else if (pub == 0) {
            n = 1;
        }

        log.info("n = " + n);
        planDAO.publicUpdateInfo(rownum, pub, n);
    }
}
