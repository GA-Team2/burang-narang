package org.ga2.buna.service;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.EventListDAO;
import org.ga2.buna.dto.EventlistDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventListImpl implements EventList {

    @Override
    public void execute(Model model) {
        EventListDAO dao = new EventListDAO();
        List<EventlistDTO> list = dao.listEvent();
        model.addAttribute("list",list);
    }
}
