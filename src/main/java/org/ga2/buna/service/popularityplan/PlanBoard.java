package org.ga2.buna.service.popularityplan;

import org.ga2.buna.dto.planboard.PopDTO;

import java.util.List;

public interface PlanBoard {
    List<PopDTO> boardList(String pageNumber, boolean like, String searchTag, int startNum);


}
