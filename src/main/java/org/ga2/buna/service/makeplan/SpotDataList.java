package org.ga2.buna.service.makeplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dto.spot.spotdetail.SpotDetailDTO;
import org.ga2.buna.service.spot.*;
import org.ga2.buna.service.spot.accommodation.AccommodationList;
import org.ga2.buna.service.spot.event.EventList;
import org.ga2.buna.service.spot.restaurant.RestaurantList;
import org.ga2.buna.service.spot.traffic.TrafficList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotDataList implements SpotData {
    private final TrafficList trafficList;
    private final AccommodationList accommodationList;
    private final RestaurantList restaurantList;
    private final EventList eventList;
    private final SpotDetailList spotDetailList;

    @Override
    public List<Spot> findAll(String spot) {
        if (spot.equals("traffic")) return trafficList.findAll();
        else if (spot.equals("accommodation")) return accommodationList.findAll();
        else if (spot.equals("restaurant")) return restaurantList.findAll();
        else return eventList.findAll();
    }

    @Override
    public List<Spot> findBySpotName(String spotName) {
        List<Spot> spotList = new ArrayList<>();

        for (SpotDetailDTO spotDetailDTO: spotDetailList.findBySpotName(spotName)) {
            String serialNumber = spotDetailDTO.getSpotSerialNumber();
            char spotCode = serialNumber.charAt(0);

            switch (spotCode) {
                case 'T':
                    spotList.add(trafficList.findBySerialNumber(serialNumber));
                    break;
                case 'A':
                    spotList.add(accommodationList.findBySerialNumber(serialNumber));
                    break;
                case 'R':
                    spotList.add(restaurantList.findBySerialNumber(serialNumber));
                    break;
                case 'E':
                    spotList.add(eventList.findBySerialNumber(serialNumber));
                    break;
            }
        }
        return spotList;
    }
}
