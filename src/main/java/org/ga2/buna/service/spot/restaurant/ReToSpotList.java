package org.ga2.buna.service.spot.restaurant;

import org.ga2.buna.dto.spot.restaurant.RestaurantDTO;
import org.ga2.buna.service.spot.Spot;
import org.springframework.stereotype.Service;

@Service
public class ReToSpotList implements ReToSpot {
    @Override
    public Spot convert(RestaurantDTO restaurantDTO) {
        Spot spot = new Spot();
        spot.setSpotSerialNumber(restaurantDTO.getSpotSerialNumber());
        spot.setSpotType(restaurantDTO.getRestaurantType());
        spot.setSpotName(restaurantDTO.getRestaurantName());
        spot.setSpotPhoneNumber(restaurantDTO.getRestaurantPhoneNumber());
        spot.setSpotLocation(restaurantDTO.getRestaurantLocation());
        spot.setSpotPhoto(restaurantDTO.getRestaurantPhoto());
        spot.setSpotStartTime(restaurantDTO.getRestaurantOpenTime());
        spot.setSpotEndTime(restaurantDTO.getRestaurantCloseTime());

        return spot;
    }
}
