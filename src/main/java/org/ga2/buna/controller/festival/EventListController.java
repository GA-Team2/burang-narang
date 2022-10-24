package org.ga2.buna.controller.festival;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.festival.EventList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class EventListController {

    private final EventList eventList;

    @RequestMapping("/Festival")
    public String festivalList(Model model){
        model.addAttribute("list",eventList.selectAll());
        return "Festival";
    }

}
