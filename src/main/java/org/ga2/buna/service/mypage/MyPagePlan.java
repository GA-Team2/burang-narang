package org.ga2.buna.service.mypage;

import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.ui.Model;

import java.util.List;

public interface MyPagePlan {
    List<PlanInfoDTO> list(Model model);
}
