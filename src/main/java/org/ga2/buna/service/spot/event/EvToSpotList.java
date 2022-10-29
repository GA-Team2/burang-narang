package org.ga2.buna.service.spot.event;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dto.spot.event.EventDTO;
import org.ga2.buna.dto.spot.SpotDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EvToSpotList implements EvToSpot {
    private final TimeToString timeToString;

    @Override
    public SpotDTO convert(EventDTO eventDTO) {
        SpotDTO spotDTO = new SpotDTO();
        spotDTO.setSpotSerialNumber(eventDTO.getSpotSerialNumber());
        spotDTO.setSpotType(eventDTO.getEventName());
        spotDTO.setSpotName(eventDTO.getEventVenue());
        spotDTO.setSpotPhoneNumber(eventDTO.getEventPhoneNumber());
        spotDTO.setSpotLocation(eventDTO.getEventLocation());
        spotDTO.setSpotPhoto(eventDTO.getEventPhoto());
        spotDTO.setSpotStartTime(timeToString.toString(eventDTO.getEventStartDate()));
        spotDTO.setSpotEndTime(timeToString.toString(eventDTO.getEventEndDate()));

        return spotDTO;
    }
}
