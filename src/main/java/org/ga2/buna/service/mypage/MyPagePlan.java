package org.ga2.buna.service.mypage;

import org.ga2.buna.dto.planinfo.PlanInfoDTO;

import java.util.List;
import java.util.Map;

public interface MyPagePlan {
    List<PlanInfoDTO> list(Map<String, Object> map, String nick);
}
