package org.ga2.buna.service.spot.event;

import org.ga2.buna.dto.spot.SpotDTO;
import org.ga2.buna.dto.spot.event.EventDTO;


public interface EvToSpot {
    SpotDTO convert(EventDTO eventDTO);
}
