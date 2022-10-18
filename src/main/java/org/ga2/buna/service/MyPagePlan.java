package org.ga2.buna.service;

import org.ga2.buna.dto.PlanInfoDTO;
import org.springframework.ui.Model;

import java.util.List;

public interface MyPagePlan {
    public List<PlanInfoDTO> list(Model model) throws Exception;
}
