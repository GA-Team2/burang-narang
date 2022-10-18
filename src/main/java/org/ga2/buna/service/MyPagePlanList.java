package org.ga2.buna.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.PlanDAO;
import org.ga2.buna.dto.PlanInfoDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyPagePlanList implements MyPagePlan{

    private final PlanDAO planDAO;


    @Override
    public List<PlanInfoDTO> list(Model model) throws Exception {

        Map<String, Object> map = model.asMap();
        String nick = String.valueOf(map.get("nick"));
//        String nick = request.getParameter("nick");

        List<PlanInfoDTO> dto = planDAO.getPlanInfo(nick);

        return planDAO.getPlanInfo(nick);
    }
}
