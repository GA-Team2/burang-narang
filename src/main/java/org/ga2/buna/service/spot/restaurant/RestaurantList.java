package org.ga2.buna.service.spot.restaurant;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.restaurant.RestaurantDAO;
import org.ga2.buna.dto.spot.restaurant.RestaurantDTO;
import org.ga2.buna.service.spot.Spot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantList implements Restaurant {
    private final RestaurantDAO restaurantDAO;
    private final ReToSpotList reToSpotList;

    @Override
    public List<Spot> findAll() {
        List<Spot> spotList = new ArrayList<>();

        for (RestaurantDTO restaurantDTO: restaurantDAO.selectAll()) {
            spotList.add(reToSpotList.convert(restaurantDTO));
        }

        return spotList;
    }

    @Override
    public Spot findBySerialNumber(String serialNumber) {
        return reToSpotList.convert(restaurantDAO.selectBySerialNumber(serialNumber));
    }
}
