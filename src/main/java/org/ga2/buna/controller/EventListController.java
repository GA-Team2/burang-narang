package org.ga2.buna.controller;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.EventList;
import org.ga2.buna.service.EventListImpl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class EventListController {
    private EventList eventlist;
    private JdbcTemplate template;

    @RequestMapping("/Festival")
    public String list(Model model) {

        eventlist = new EventListImpl();

        eventlist.findAll();

        return "Festival";
    }
}
