package org.ga2.buna.service.plandetail;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.PlanDAO;
import org.ga2.buna.dto.PlanJoinDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanDetailListImpl implements PlanDetailList{

    private final PlanDAO planDAO;

    @Override
    public List<PlanJoinDTO> planList(Model model) {

        int rownum = (int) model.getAttribute("rownum");
        planDAO.getPlanDetail(rownum);

        String mypage = (String) model.getAttribute("mypage");

        return null;
    }
}
