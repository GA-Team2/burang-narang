package org.ga2.buna.service.plandetail;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.PlanDAO;
import org.ga2.buna.dto.plandetail.PlanJoinDTO;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchingMapInfoAllImpl implements SearchingMapInfoAll {
    private final PlanDAO planDAO;

    @Override
    public List<SearchInfoDTO> findInfoAll(int planRownum) {
        return planDAO.getSearchInfo(planRownum);
    }
}
