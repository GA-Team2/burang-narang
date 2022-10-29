package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.planboard.PopRepository;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanTopTotalList implements PlanTopTotal {

    private final PopRepository popRepository;

    @Override
    public List<PlanInfoDTO> findTotal() {
        return popRepository.topTotal();
    }
}
