package org.ga2.buna.service.spot.restaurant;

import org.ga2.buna.dto.spot.restaurant.RestaurantDTO;
import org.ga2.buna.service.spot.Spot;

public interface ReToSpot {
    Spot convert(RestaurantDTO restaurantDTO);
}
