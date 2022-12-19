package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.planboard.PopRepository;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanTop20List implements PlanTop20 {

    private final PopRepository popRepository;

    @Override
    public List<PlanInfoDTO> find20() {
        return popRepository.top20();
    }
}
