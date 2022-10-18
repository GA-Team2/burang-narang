package org.ga2.buna.controller.popularityplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.eventlist.EventList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class PopularityPlanController {

//    private final EventList eventlist;

    @RequestMapping("/PopularityPlan")
    public String festivalList(Model model){
//        model.addAttribute("list",eventlist.findAll());
        return "PopularityPlan";
    }
}
