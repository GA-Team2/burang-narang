package org.ga2.buna.service.spot.restaurant;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.restaurant.RestaurantRepository;
import org.ga2.buna.dto.spot.restaurant.RestaurantDTO;
import org.ga2.buna.dto.spot.SpotDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantList implements Restaurant {
    private final RestaurantRepository restaurantRepository;
    private final ReToSpot reToSpot;

    @Override
    public List<SpotDTO> findAll() {
        List<SpotDTO> spotList = new ArrayList<>();

        for (RestaurantDTO restaurantDTO: restaurantRepository.selectAll()) {
            spotList.add(reToSpot.convert(restaurantDTO));
        }

        return spotList;
    }

    @Override
    public SpotDTO findBySerialNumber(String serialNumber) {
        return reToSpot.convert(restaurantRepository.selectBySerialNumber(serialNumber));
    }
}
