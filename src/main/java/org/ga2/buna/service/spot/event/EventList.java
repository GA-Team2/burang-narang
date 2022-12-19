package org.ga2.buna.service.spot.event;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.event.EventRepository;
import org.ga2.buna.dto.spot.event.EventDTO;
import org.ga2.buna.dto.spot.SpotDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 이벤트 데이터 리스트 반환하는 클래스
 *
 * @author 한애채
 */
@Service
@RequiredArgsConstructor
public class EventList implements Event {
    private final EventRepository eventRepository;
    private final EvToSpot evToSpot;

    /**
     * 이벤트 데이터 리스트 반환
     *
     * @return 장소 데이터 리스트
     */
    @Override
    public List<SpotDTO> findAll() {
        List<SpotDTO> spotList = new ArrayList<>();
        for (EventDTO eventDTO : eventRepository.selectAll()) {
            spotList.add(evToSpot.convert(eventDTO));
        }
        return spotList;
    }

    /**
     * 장소 고유 번호를 가지는 이벤트 데이터 반환
     *
     * @param serialNumber 장소 고유 번호
     * @return 장소 데이터
     */
    @Override
    public SpotDTO findBySerialNumber(String serialNumber) {
        return evToSpot.convert(eventRepository.selectBySerialNumber(serialNumber));
    }
}
