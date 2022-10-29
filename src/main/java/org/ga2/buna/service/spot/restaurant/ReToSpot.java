package org.ga2.buna.service.spot.restaurant;

import org.ga2.buna.dto.spot.SpotDTO;
import org.ga2.buna.dto.spot.restaurant.RestaurantDTO;

public interface ReToSpot {
    SpotDTO convert(RestaurantDTO restaurantDTO);
}
