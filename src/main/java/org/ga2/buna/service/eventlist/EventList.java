package org.ga2.buna.service.eventlist;

import org.ga2.buna.dto.EventlistDTO;

import java.util.List;

public interface EventList {

    List<EventlistDTO> findAll();
}
