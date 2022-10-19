package org.ga2.buna.service.makeplan;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.accommodation.AccommodationDAO;
import org.ga2.buna.dao.event.EventDAO;
import org.ga2.buna.dao.restaurant.RestaurantDAO;
import org.ga2.buna.dao.traffic.TrafficDAO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpotMap {

    private final TrafficDAO trafficDAO;
    private final AccommodationDAO accommodationDAO;
    private final RestaurantDAO restaurantDAO;
    private final EventDAO eventDAO;

    public String getTraffic() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(trafficDAO.selectAll());
    }

    public String getRestaurant() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(restaurantDAO.selectAll());
    }

    public String getAccommodation() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(accommodationDAO.selectAll());
    }

    public String getEvent() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(eventDAO.selectAll());
    }

    public String getSpot(String spot) throws Exception {
        if(spot.equals("traffic")) return this.getTraffic();
        else if (spot.equals("accommodation")) return this.getAccommodation();
        else if (spot.equals("restaurant")) return this.getRestaurant();
        else return this.getEvent();
    }
}
