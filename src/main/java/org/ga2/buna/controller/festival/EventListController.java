package org.ga2.buna.controller.festival;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.festival.EventList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class EventListController {

    private final EventList eventlist;

    @RequestMapping("/Festival")
    public String festivalList(Model model, HttpServletResponse response){
        response.setContentType("image/jpeg");
        model.addAttribute("list",eventlist.selectAll());
        return "Festival";
    }
}
