package org.ga2.buna.service.festival;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.EventListDAO;
import org.ga2.buna.dao.spot.event.EventDAO;
import org.ga2.buna.dto.spot.event.EventDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventListImpl implements EventList {

    private final EventListDAO eventListDAO;

    @Override
    public List<EventDTO> selectAll() {
        return eventListDAO.listEvent();
    }
}