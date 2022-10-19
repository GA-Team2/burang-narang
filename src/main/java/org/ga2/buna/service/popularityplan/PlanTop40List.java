package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.planboard.PopDAO;
import org.ga2.buna.dto.board.PopDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanTop40List implements PlanTop40 {

    private  final PopDAO popDAO;

    @Override
    public List<PopDTO> find40() {
        return popDAO.popTop6();
    }
}
