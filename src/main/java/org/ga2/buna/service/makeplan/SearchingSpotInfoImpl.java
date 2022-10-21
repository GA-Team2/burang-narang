package org.ga2.buna.service.makeplan;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.PlanDAO;
import org.ga2.buna.dao.plandetail.PlanDetailDAO;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchingSpotInfoImpl implements SearchingSpotInfo {
    private final PlanDAO planDAO;
    private final PlanDetailDAO planDetail;

    @Override
    public List<SearchInfoDTO> getInfo(int planRownum) {
        return planDAO.getSearchInfo(planRownum);
    }

    @Override
    public SearchInfoDTO getInfo(String spotName, String serialNumber) {
        return planDetail.selectSearchInfo(spotName, serialNumber);
    }
}