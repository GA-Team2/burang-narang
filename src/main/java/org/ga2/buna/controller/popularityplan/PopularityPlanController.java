package org.ga2.buna.controller.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.popularityplan.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PopularityPlanController {

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


@RequestMapping("/PopularityPlan")
    public String hashtagList(@RequestParam(value = "like",required = false, defaultValue = "false") boolean  like,
                              @RequestParam(value = "startNum",required = false, defaultValue = "0") int startNum,
                              String searchTag,String pageNumber, Model model) {


        model.addAttribute("popBoard",planBoard.boardList(pageNumber, like, searchTag, startNum));

        model.addAttribute("pagingBoard",pagingBoard.pageNumber(5));

        model.addAttribute("popTag", planBoardHashtag.findAll());

        model.addAttribute("popTopAll",planTopTotal.findTotal());
        model.addAttribute("popTopMan",planTopMan.findMan());
        model.addAttribute("popTopWoman",planTopWoman.findWoman());
        model.addAttribute("popTop20",planTop20.find20());
        model.addAttribute("popTop30",planTop30.find30());
        model.addAttribute("popTop40",planTop40.find40());
        model.addAttribute("popTop50",planTop50.find50());

        return "PopularityPlan";
    }
}

