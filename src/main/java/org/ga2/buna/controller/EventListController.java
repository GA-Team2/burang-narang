package org.ga2.buna.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.EventList;
import org.ga2.buna.service.EventListImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Festival")
public class EventListController {
    public JdbcTemplate jdbcTemplate;
    EventList eventlist;

    public String festivalList(Model model){
        eventlist = new EventListImpl();
        eventlist.execute(model);

        return "Festival";
    }
}
