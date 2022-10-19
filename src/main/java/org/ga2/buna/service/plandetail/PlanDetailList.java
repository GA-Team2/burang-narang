package org.ga2.buna.service.plandetail;

import org.ga2.buna.dto.PlanJoinDTO;
import org.springframework.ui.Model;

import java.util.List;

public interface PlanDetailList {

    public List<PlanJoinDTO> planList(Model model);
}
