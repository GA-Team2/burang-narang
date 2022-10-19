package org.ga2.buna.service.makeplan;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.accommodation.AccommodationDAO;
import org.ga2.buna.dao.spot.event.EventDAO;
import org.ga2.buna.dao.spot.restaurant.RestaurantDAO;
import org.ga2.buna.dao.spot.traffic.TrafficDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotList {

    private final TrafficDAO trafficDAO;
    private final AccommodationDAO accommodationDAO;
    private final RestaurantDAO restaurantDAO;
    private final EventDAO eventDAO;

    public List<?> getSpot(String spot) throws Exception {
        if(spot.equals("traffic")) return trafficDAO.selectAll();
        else if (spot.equals("accommodation")) return accommodationDAO.selectAll();
        else if (spot.equals("restaurant")) return restaurantDAO.selectAll();
        else return eventDAO.selectAll();
    }
}
