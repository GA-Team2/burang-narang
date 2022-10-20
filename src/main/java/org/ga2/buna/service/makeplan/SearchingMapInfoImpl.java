package org.ga2.buna.service.makeplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.plandetail.PlanDetailDAO;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchingMapInfoImpl implements SearchingMapInfo {
    private final PlanDetailDAO planDetail;

    @Override
    public SearchInfoDTO searchInfo(String spotname, String serialnum) {
        return planDetail.selectSearchInfo(spotname, serialnum);
    }
}
