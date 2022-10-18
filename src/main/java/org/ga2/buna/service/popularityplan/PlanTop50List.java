package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.board.PopDAO;
import org.ga2.buna.dto.board.PopDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanTop50List implements PlanTop50 {

    private  final PopDAO popdao;

    @Override
    public List<PopDTO> find50() {
        return popdao.popTop7();
    }
}
