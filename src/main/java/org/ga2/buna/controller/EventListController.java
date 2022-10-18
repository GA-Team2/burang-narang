package org.ga2.buna.controller;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.EventList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class EventListController {

    private final EventList eventlist;

    @RequestMapping("/Festival")
    public String festivalList(Model model){
        model.addAttribute("list",eventlist.findAll());
        return "Festival";
    }
}
