package org.ga2.buna.service.spot;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.event.EventDAO;
import org.ga2.buna.dto.spot.event.EventDTO;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
            spot.setSpotPhoneNumber(eventDTO.getEventPhoneNumber());
            spot.setSpotLocation(eventDTO.getEventLocation());
            spot.setSpotPhoto(eventDTO.getEventPhoto());

            /* timestamp -> string yyyy-mm-dd 변환 */
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String startDate = dateFormat.format(eventDTO.getEventStartDate());
            String endDate = dateFormat.format(eventDTO.getEventEndDate());
            spot.setSpotStartTime(startDate);
            spot.setSpotEndTime(endDate);

            spotList.add(spot);
        }

        return spotList;
    }
}
