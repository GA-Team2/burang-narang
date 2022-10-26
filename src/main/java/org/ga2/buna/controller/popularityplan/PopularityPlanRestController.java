package org.ga2.buna.controller.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dto.planboard.PopDTO;
import org.ga2.buna.service.popularityplan.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/popularity")
public class PopularityPlanRestController {

    private final PlanBoard planBoard;
    private final PagingBoard pagingBoard;
    private final PlanBoardHashtag planBoardHashtag;
    private final PlanTopTotal planTopTotal;
    private final PlanTopMan planTopMan;
    private final PlanTopWoman planTopWoman;
    private final PlanTop20 planTop20;
    private final PlanTop30 planTop30;
    private final PlanTop40 planTop40;
    private final PlanTop50 planTop50;

    @GetMapping("/board")
    public List<PopDTO> searchBoardList(String like,
                                     @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                     String searchTag, Model model) {

        System.out.println("searchTag@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ = " + searchTag);
        //like = 추천순, startNum = 페이징, searchTag = 태그검색

        //게시판
        model.addAttribute("popBoard", planBoard.boardList(like, searchTag, page));


        return planBoard.boardList(like, searchTag, page);
    }
}

