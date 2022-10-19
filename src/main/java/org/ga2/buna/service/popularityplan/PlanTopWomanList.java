package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.board.PopDAO;
import org.ga2.buna.dto.board.PopDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanTopWomanList implements PlanTopWoman {

    private final PopDAO popDAO;

    @Override
    public List<PopDTO> findWoman() {
        return popDAO.popTop3();
    }
}
