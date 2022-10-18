package org.ga2.buna.service.festival;

import org.ga2.buna.dto.EventlistDTO;

import java.util.List;

public interface EventList {

    List<EventlistDTO> findAll();
}
