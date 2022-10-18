package org.ga2.buna.controller.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.popularityplan.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class PopularityPlanController {

    private final PlanBoardHashtag planboardhashtag;
    private final PlanTopTotal planTopTotal;
    private final PlanTopMan planTopMan;
    private final PlanTopWoman planTopWoman;
    private final PlanTop20 planTop20;
    private final PlanTop30 planTop30;
    private final PlanTop40 planTop40;
    private final PlanTop50 planTop50;


@RequestMapping("/PopularityPlan")
    public String hashtagList(Model model) {
    System.out.println(" =@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ");
        model.addAttribute("popTag", planboardhashtag.findAll());
        model.addAttribute("popTopAll",planTopTotal.findTotal());
        model.addAttribute("popTopMan",planTopMan.findMan());
        model.addAttribute("popTopWoman",planTopWoman.findWoman());
        model.addAttribute("popTop20",planTop20.find20());
        model.addAttribute("popTop30",planTop30.find30());
        model.addAttribute("popTop40",planTop40.find40());
        model.addAttribute("popTop50",planTop50.find50());

    System.out.println(" =@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ");
        return "PopularityPlan";
    }
//    public String TopPlanTotal(Model model){
//        model.addAttribute("popTopAll",planTopTotal.findTotal());
//        return "PopularityPlan";
//    }
//
//    public String TopPlanMan(Model model){
//        model.addAttribute("popTopMan",planTopMan.findMan());
//        return "PopularityPlan";
//    }
//
//    public String TopPlanWoman(Model model){
//        model.addAttribute("popTopWoman",planTopWoman.findWoman());
//        return "PopularityPlan";
//    }
//
//    public String TopPlan20(Model model){
//        model.addAttribute("popTop20",planTop20.find20());
//        return "PopularityPlan";
//    }
//
//    public String TopPlan30(Model model){
//        model.addAttribute("popTop30",planTop30.find30());
//        return "PopularityPlan";
//    }
//
//    public String TopPlan40(Model model){
//        model.addAttribute("popTop40",planTop40.find40());
//        return "PopularityPlan";
//    }
//
//    public String TopPlan50(Model model){
//        model.addAttribute("popTop50",planTop50.find50());
//        return "PopularityPlan";
//    }
}
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

