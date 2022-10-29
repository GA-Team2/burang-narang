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
    @Select("select s_serialnum as spot_serial_number, " +
            "r_type as restaurant_type, " +
            "r_name as restaurant_name, " +
            "r_pnumber as restaurant_phone_number, " +
            "r_location as restaurant_location, " +
            "r_opentime as restaurant_open_time, " +
            "r_closetime as restaurant_close_time, " +
            "r_photo as restaurant_photo " +
            "from restaurant")
    public List<RestaurantDTO> selectAll();

    /**
     * 시리얼 넘버 변수를 통해 해당 맛집의 정보를 반환하는 클래스
     *
     * @param serialNumber 장소 고유 번호
     * @return 맛집 객체
     *
     */
    @Select("select s_serialnum as spot_serial_number, " +
            "r_type as restaurant_type, " +
            "r_name as restaurant_name, " +
            "r_pnumber as restaurant_phone_number, " +
            "r_location as restaurant_location, " +
            "r_opentime as restaurant_open_time, " +
            "r_closetime as restaurant_close_time, " +
            "r_photo as restaurant_photo " +
            "from restaurant WHERE S_SERIALNUM = #{serialNumber}")
    RestaurantDTO selectBySerialNumber(String serialNumber);
}
