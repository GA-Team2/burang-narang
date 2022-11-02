package org.ga2.buna.service.spot.restaurant;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.restaurant.RestaurantRepository;
import org.ga2.buna.dto.spot.restaurant.RestaurantDTO;
import org.ga2.buna.dto.spot.SpotDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 맛집 데이터 리스트 반환하는 클래스
 *
 * @author 한애채
 */
@Service
@RequiredArgsConstructor
public class RestaurantList implements Restaurant {
    private final RestaurantRepository restaurantRepository;
    private final ReToSpot reToSpot;

    /**
     * 맛집 데이터 리스트 반환
     *
     * @return 장소 데이터 리스트
     */
    @Override
    public List<SpotDTO> findAll() {
        List<SpotDTO> spotList = new ArrayList<>();

        for (RestaurantDTO restaurantDTO : restaurantRepository.selectAll()) {
            spotList.add(reToSpot.convert(restaurantDTO));
        }

        return spotList;
    }

    /**
     * 장소 고유 번호를 가지는 맛집 데이터 반환
     *
     * @param serialNumber 장소 고유 번호
     * @return 장소 데이터
     */
    @Override
    public SpotDTO findBySerialNumber(String serialNumber) {
        return reToSpot.convert(restaurantRepository.selectBySerialNumber(serialNumber));
    }
}
