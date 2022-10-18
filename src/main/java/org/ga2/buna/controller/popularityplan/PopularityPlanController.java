package org.ga2.buna.controller.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.popularityplan.PlanBoardHashtag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/PopularityPlan")
public class PopularityPlanController {

    private  final PlanBoardHashtag planboardhashtag;

    @GetMapping
    public String hashtagList(Model model){
        model.addAttribute("list",planboardhashtag.findAll());
        return "PopularityPlan";

        //전체 인기순
//        ArrayList<PopDTO> poptopall = dao.popTop(1);
//        request.setAttribute("popTopAll", poptopall);

        //남자 인기순
//        ArrayList<PopDTO> poptopman = dao.popTop(2);
//        request.setAttribute("popTopMan", poptopman);

        //여자 인기순
//        ArrayList<PopDTO> poptopwoman = dao.popTop(3);
//        request.setAttribute("popTopWoman", poptopwoman);

        //20대 인기순
//        ArrayList<PopDTO> poptop20 = dao.popTop(4);
//        request.setAttribute("popTop20", poptop20);

        //30대 인기순
//        ArrayList<PopDTO> poptop30 = dao.popTop(5);
//        request.setAttribute("popTop30", poptop30);

        //40대 인기순
//        ArrayList<PopDTO> poptop40 = dao.popTop(6);
//        request.setAttribute("popTop40", poptop40);

        //50대 인기순
//        ArrayList<PopDTO> poptop50 = dao.popTop(7);
//        request.setAttribute("popTop50", poptop50);
    }
}
