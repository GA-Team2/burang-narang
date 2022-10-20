package org.ga2.buna.service.makeplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.service.spot.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotDataList implements SpotData {

    private final ConvertTrafficToSpot convertTrafficToSpot;
    private final ConvertAccommodationToSpot convertAccommodationToSpot;
    private final ConvertRestaurantToSpot convertRestaurantToSpot;
    private final ConvertEventToSpot convertEventToSpot;
    private final SerialNumberToSpot serialNumberToSpot;



    @Override
    public List<Spot> findAll(String spot) {
        if (spot.equals("traffic")) return convertTrafficToSpot.convertAll();
        else if (spot.equals("accommodation")) return convertAccommodationToSpot.findAll();
        else if (spot.equals("restaurant")) return convertRestaurantToSpot.convertAll();
        else return convertEventToSpot.convertAll();
    }

    public List<Spot> findBySpotName(String spotName) {
        return serialNumberToSpot.findBySerialNumber(spotName);
    }
}
