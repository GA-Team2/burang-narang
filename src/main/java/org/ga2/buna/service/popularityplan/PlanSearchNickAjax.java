package org.ga2.buna.service.popularityplan;

import org.ga2.buna.dto.planinfo.PlanInfoDTO;

import java.util.List;

public interface PlanSearchNickAjax {
    List<PlanInfoDTO> boardNickListAjax(String nick);
}
