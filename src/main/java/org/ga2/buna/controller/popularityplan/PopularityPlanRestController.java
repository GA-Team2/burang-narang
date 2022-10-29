package org.ga2.buna.controller.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.ga2.buna.service.popularityplan.PlanBoard;
import org.ga2.buna.service.popularityplan.PlanBoardAjax;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/popularity")
public class PopularityPlanRestController {

    private final PlanBoardAjax planBoardAjax;
    private final PlanBoard planBoard;

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PlanInfoDTO> searchBoardList(String searchTag) {

        return planBoardAjax.boardListAjax(searchTag);
    }

    @GetMapping("/paging")
    public List<PlanInfoDTO> pageBoardList(String like,
                                           @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                           String searchTag) {

        return planBoard.boardList(like, searchTag, page);
    }
}

