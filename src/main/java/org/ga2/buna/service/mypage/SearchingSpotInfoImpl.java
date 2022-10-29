package org.ga2.buna.service.mypage;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.plandetail.PlanDetailRepository;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchingSpotInfoImpl implements SearchingSpotInfo {
    private final PlanDetailRepository planDetailDAO;

    @Override
    public List<SearchInfoDTO> getInfo(int planRownum) {
        return planDetailDAO.getSearchInfo(planRownum);
    }
}
