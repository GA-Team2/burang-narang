package org.ga2.buna.service.spot.event;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.event.EventRepository;
import org.ga2.buna.dto.spot.event.EventDTO;
import org.ga2.buna.service.spot.Spot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventList implements Event {
    private final EventRepository eventRepository;
    private final EvToSpot evToSpot;

    @Override
    public List<Spot> findAll() {
        List<Spot> spotList = new ArrayList<>();
        for (EventDTO eventDTO: eventRepository.selectAll()) {
           spotList.add(evToSpot.convert(eventDTO));
        }
        return spotList;
    }

    @Override
    public Spot findBySerialNumber(String serialNumber) {
        return evToSpot.convert(eventRepository.selectBySerialNumber(serialNumber));
    }
}
