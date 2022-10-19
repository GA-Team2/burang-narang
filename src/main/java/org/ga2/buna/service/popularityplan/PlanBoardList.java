package org.ga2.buna.service.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.planboard.PopDAO;
import org.ga2.buna.dto.planboard.PopDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanBoardList implements PlanBoard{

    private final PopDAO popDAO;

    @Override
    public List<PopDTO> boardList(boolean like, String searchTag) {
        System.out.println("searchTag@@@@@@@@@@@@@@ = " + searchTag);
        if (searchTag != null) {
            return popDAO.searchTag(searchTag);
        } else {
            if (like == true) {
                return popDAO.boardLike();
            }
        }
        return popDAO.popBoard();
    }
}
