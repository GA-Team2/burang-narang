package org.ga2.buna.service.popularityplan;

import org.ga2.buna.dto.planinfo.PlanInfoDTO;

import java.util.List;

public interface PlanBoard {
    List<PlanInfoDTO> boardList(String like, String searchTag, int page);
}
