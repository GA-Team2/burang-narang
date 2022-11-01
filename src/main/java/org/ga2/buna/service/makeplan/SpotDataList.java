package org.ga2.buna.service.makeplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dto.spot.SpotDTO;
import org.ga2.buna.dto.spot.spotdetail.SpotDetailDTO;
import org.ga2.buna.service.spot.*;
import org.ga2.buna.service.spot.accommodation.Accommodation;
import org.ga2.buna.service.spot.event.Event;
import org.ga2.buna.service.spot.restaurant.Restaurant;
import org.ga2.buna.service.spot.traffic.Traffic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 장소 정보 리스트 반환하는 메서드
 *
 * @author 한애채
 */
@Service
@RequiredArgsConstructor
public class SpotDataList implements SpotData {
    private final Traffic traffic;
    private final Accommodation accommodation;
    private final Restaurant restaurant;
    private final Event event;
    private final SpotDetailList spotDetailList;

    /**
     * 각 타입에 맞는 장소 정보 반환하는 메서드
     *
     * @param spot 장소 타입
     * @return spot 타입에 따른 장소 정보 리스트
     */
    @Override
    public List<SpotDTO> findAll(String spot) {
        if (spot.equals("traffic")) return traffic.findAll();
        else if (spot.equals("accommodation")) return accommodation.findAll();
        else if (spot.equals("restaurant")) return restaurant.findAll();
        else return event.findAll();
    }

    /**
     * 장소 이름으로 검색했을 때 장소 정보 리스트 반환하는 메서드
     *
     * @param spotName 장소 이름
     * @return 장소 정보 리스트
     */
    @Override
    public List<SpotDTO> findBySpotName(String spotName) {
        List<SpotDTO> spotList = new ArrayList<>();

        for (SpotDetailDTO spotDetailDTO : spotDetailList.findBySpotName(spotName)) {
            String serialNumber = spotDetailDTO.getSpotSerialNumber();
            char spotCode = serialNumber.charAt(0);

            switch (spotCode) {
                case 'T':
                    spotList.add(traffic.findBySerialNumber(serialNumber));
                    break;
                case 'A':
                    spotList.add(accommodation.findBySerialNumber(serialNumber));
                    break;
                case 'R':
                    spotList.add(restaurant.findBySerialNumber(serialNumber));
                    break;
                case 'E':
                    spotList.add(event.findBySerialNumber(serialNumber));
                    break;
            }
        }
        return spotList;
    }
}
