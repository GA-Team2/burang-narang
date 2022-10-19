package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.planboard.PopDAO;
import org.ga2.buna.dto.planboard.PopDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanTopTotalList implements PlanTopTotal {

    private  final PopDAO popDAO;

    @Override
    public List<PopDTO> findTotal() {
        return popDAO.popTop1();
    }
}
