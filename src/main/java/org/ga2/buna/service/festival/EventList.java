package org.ga2.buna.service.festival;


import org.ga2.buna.dto.spot.event.EventDTO;

import java.util.List;

public interface EventList {

    List<EventDTO> selectAll();
}
