package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.planboard.PopDAO;
import org.ga2.buna.dto.planboard.PopDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanTop30List implements PlanTop30 {

    private final PopDAO popDAO;

    @Override
    public List<PopDTO> find30() {
        return popDAO.top30();
    }
}