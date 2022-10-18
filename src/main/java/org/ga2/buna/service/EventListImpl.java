package org.ga2.buna.service;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.EventListDAO;
import org.ga2.buna.dto.EventlistDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventListImpl implements EventList {

    private final EventListDAO eventlistdao;

    @Override
    public List<EventlistDTO> findAll() {
        return eventlistdao.listEvent();
    }
}
