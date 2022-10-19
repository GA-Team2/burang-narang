package org.ga2.buna.service.spot;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.event.EventDAO;
import org.ga2.buna.dto.spot.event.EventDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConvertEventToSpot implements EventToSpot {
    private final EventDAO eventDAO;

    @Override
    public List<Spot> convertAll() {
        List<Spot> spotList = new ArrayList<>();

        for (EventDTO eventDTO: eventDAO.selectAll()) {
            Spot spot = new Spot();
            spot.setSpotSerialNumber(eventDTO.getSpotSerialNumber());
            spot.setSpotType(eventDTO.getEventName());
            spot.setSpotName(eventDTO.getEventVenue());
            spot.setSpotPhoneNumber(eventDTO.getTrafficPhoneNumber());
            spot.setSpotLocation(eventDTO.getTrafficLocation());
            spot.setSpotPhoto(eventDTO.getTrafficPhoto());
            spot.setSpotStartTime("");
            spot.setSpotEndTime("");

            spotList.add(spot);
        }

        return spotList;
    }
}
