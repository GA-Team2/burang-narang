package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.PlanDAO;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyPagePlanList implements MyPagePlan{

    private final PlanDAO planDAO;

    @Override
    public List<PlanInfoDTO> list(Model model, HttpSession session) {

        String nick = (String) session.getAttribute("nick_s");
        List<PlanInfoDTO> dto = planDAO.getPlanInfo(nick);

        return planDAO.getPlanInfo(nick);
    }
}
