package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.planboard.PopRepository;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanTop50List implements PlanTop50 {

    private final PopRepository popRepository;

    @Override
    public List<PlanInfoDTO> find50() {
        return popRepository.top50();
    }
}
