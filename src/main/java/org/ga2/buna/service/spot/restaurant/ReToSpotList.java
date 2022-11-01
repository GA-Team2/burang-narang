package org.ga2.buna.service.spot.restaurant;

import org.ga2.buna.dto.spot.restaurant.RestaurantDTO;
import org.ga2.buna.dto.spot.SpotDTO;
import org.springframework.stereotype.Service;

/**
 * 맛집 데이터를 장소 데이터로 전환하는 클래스
 *
 * @author 한애채
 */
@Service
public class ReToSpotList implements ReToSpot {

    /**
     * 맛집 데이터를 장소 데이터로 전환하는 클래스
     *
     * @param restaurantDTO 맛집 데이터 객체
     * @return 장소 데이터 객체
     */
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
