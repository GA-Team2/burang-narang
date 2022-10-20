package org.ga2.buna.service.makeplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.accommodation.AccommodationDAO;
import org.ga2.buna.dao.spot.event.EventDAO;
import org.ga2.buna.dao.spot.restaurant.RestaurantDAO;
import org.ga2.buna.dao.spot.traffic.TrafficDAO;
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



    @Override
    public List<Spot> findAll(String spot) {
        if (spot.equals("traffic")) return convertTrafficToSpot.convertAll();
        else if (spot.equals("accommodation")) return convertAccommodationToSpot.convertAll();
        else if (spot.equals("restaurant")) return convertRestaurantToSpot.convertAll();
        else return convertEventToSpot.convertAll();
    }
}
