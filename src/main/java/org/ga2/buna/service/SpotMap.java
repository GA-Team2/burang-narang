package org.ga2.buna.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.RestaurantDAO;
import org.ga2.buna.dao.TrafficDAO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpotMap {

    private final TrafficDAO trafficDAO;
    private final RestaurantDAO restaurantDAO;

    public String getTraffic() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(trafficDAO.getTrafficList());
    }

    public String getRestaurant() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(restaurantDAO.getRestaurantList());
    }
}
