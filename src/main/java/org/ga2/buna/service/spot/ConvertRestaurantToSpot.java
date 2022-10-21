package org.ga2.buna.service.spot;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.restaurant.RestaurantDAO;
import org.ga2.buna.dto.spot.restaurant.RestaurantDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConvertRestaurantToSpot implements RestaurantToSpot {
    private final RestaurantDAO restaurantDAO;

    @Override
    public List<Spot> convertAll() {
        List<Spot> spotList = new ArrayList<>();

        for (RestaurantDTO restaurantDTO: restaurantDAO.selectAll()) {
            Spot spot = new Spot();
            spot.setSpotSerialNumber(restaurantDTO.getSpotSerialNumber());
            spot.setSpotType(restaurantDTO.getRestaurantType());
            spot.setSpotName(restaurantDTO.getRestaurantName());
            spot.setSpotPhoneNumber(restaurantDTO.getRestaurantPhoneNumber());
            spot.setSpotLocation(restaurantDTO.getRestaurantLocation());
            spot.setSpotPhoto(restaurantDTO.getRestaurantPhoto());
            spot.setSpotStartTime(restaurantDTO.getRestaurantOpenTime());
            spot.setSpotEndTime(restaurantDTO.getRestaurantCloseTime());

            spotList.add(spot);
        }

        return spotList;
    }
}
