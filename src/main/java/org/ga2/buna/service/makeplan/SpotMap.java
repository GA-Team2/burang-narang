package org.ga2.buna.service.makeplan;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.restaurant.RestaurantDAO;
import org.ga2.buna.dao.traffic.TrafficDAO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpotMap {

    private final TrafficDAO trafficDAO;
    private final RestaurantDAO restaurantDAO;

    public String getTraffic() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(trafficDAO.selectAll());
    }

    public String getRestaurant() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(restaurantDAO.selectAll());
    }
}
