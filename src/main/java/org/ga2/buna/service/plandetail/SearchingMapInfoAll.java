package org.ga2.buna.service.plandetail;

import org.ga2.buna.dto.plandetail.PlanJoinDTO;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;

import java.util.List;

public interface SearchingMapInfoAll {
    List<SearchInfoDTO> findInfoAll(int rownum);
}
