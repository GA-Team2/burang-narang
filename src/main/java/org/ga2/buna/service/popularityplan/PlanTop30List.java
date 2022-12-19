package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.planboard.PopRepository;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanTop30List implements PlanTop30 {

    private final PopRepository popRepository;

    @Override
    public List<PlanInfoDTO> find30() {
        return popRepository.top30();
    }
}
