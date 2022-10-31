package org.ga2.buna.service.spot.restaurant;

import org.ga2.buna.dto.spot.restaurant.RestaurantDTO;
import org.ga2.buna.dto.spot.SpotDTO;
import org.springframework.stereotype.Service;

@Service
public class ReToSpotList implements ReToSpot {
    @Override
    public SpotDTO convert(RestaurantDTO restaurantDTO) {
        SpotDTO spotDTO = new SpotDTO();
        spotDTO.setSpotSerialNumber(restaurantDTO.getSpotSerialNumber());
        spotDTO.setSpotType(restaurantDTO.getRestaurantType());
        spotDTO.setSpotName(restaurantDTO.getRestaurantName());
        spotDTO.setSpotPhoneNumber(restaurantDTO.getRestaurantPhoneNumber());
        spotDTO.setSpotLocation(restaurantDTO.getRestaurantLocation());
        spotDTO.setSpotPhoto(restaurantDTO.getRestaurantPhoto());
        spotDTO.setSpotStartTime(restaurantDTO.getRestaurantOpenTime());
        spotDTO.setSpotEndTime(restaurantDTO.getRestaurantCloseTime());

        return spotDTO;
    }
}
