package org.ga2.buna.service;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dto.EventlistDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class EventListImpl implements EventList {

    @Override
    public ArrayList<EventlistDTO> listFestival() {
        return null;
    }
}
