package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.PlanDAO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DeletePlanInfoImpl implements DeletePlanInfo {

    private final PlanDAO planDAO;

    @Override
    public void deletePlan(Model model)  {

        int rownum = Integer.parseInt(String.valueOf(model.getAttribute("rownum")));
        planDAO.deletePlan(rownum);

    }
}
