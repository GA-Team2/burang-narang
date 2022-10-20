package org.ga2.buna.service.spot.event;

import org.ga2.buna.dto.spot.event.EventDTO;
import org.ga2.buna.service.spot.Spot;

public interface EvToSpot {
    Spot convert(EventDTO eventDTO);
}
