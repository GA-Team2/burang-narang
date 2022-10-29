package org.ga2.buna.dao.spot.restaurant;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.spot.restaurant.RestaurantDTO;

import java.util.List;

@Mapper
public interface RestaurantMapper {
    /**
     * 맛집 DB 정보 반환하는 메서드
     *
     * @return 맛집 객체 리스트
     *
     */
    @Select("SELECT * FROM RESTAURANT")
    public List<RestaurantDTO> selectAll();

    /**
     * 시리얼 넘버 변수를 통해 해당 맛집의 정보를 반환하는 클래스
     *
     * @param serialNumber 장소 고유 번호
     * @return 맛집 객체
     *
     */
    @Select("SELECT * FROM RESTAURANT WHERE S_SERIALNUM = #{serialNumber}")
    RestaurantDTO selectBySerialNumber(String serialNumber);
}
