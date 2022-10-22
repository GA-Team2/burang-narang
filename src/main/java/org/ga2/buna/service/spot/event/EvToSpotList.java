package org.ga2.buna.service.spot.event;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dto.spot.event.EventDTO;
import org.ga2.buna.service.spot.Spot;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EvToSpotList implements EvToSpot {
    private final TimeToString timeToString;

    @Override
    public Spot convert(EventDTO eventDTO) {
        Spot spot = new Spot();
        spot.setSpotSerialNumber(eventDTO.getSpotSerialNumber());
        spot.setSpotType(eventDTO.getEventName());
        spot.setSpotName(eventDTO.getEventVenue());
        spot.setSpotPhoneNumber(eventDTO.getEventPhoneNumber());
        spot.setSpotLocation(eventDTO.getEventLocation());
        spot.setSpotPhoto(eventDTO.getEventPhoto());
        spot.setSpotStartTime(timeToString.toString(eventDTO.getEventStartDate()));
        spot.setSpotEndTime(timeToString.toString(eventDTO.getEventEndDate()));

        return spot;
    }
}
