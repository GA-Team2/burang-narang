package org.ga2.buna.dao.spot.accommodation;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.spot.accommodation.AccommodationDTO;

import java.util.List;

@Mapper
public interface AccommodationMapper {

    /*
     * 숙소 정보 리스트를 반환하는 메서드
     */
    @Select("select s_serialnum as spot_serial_number, " +
            "a_type as accommodation_type, " +
            "a_name as accommodation_name, " +
            "a_pnumber as accommodation_phone_number, " +
            "a_location as accommodation_location, " +
            "a_checkin as accommodation_check_in, " +
            "a_checkout as accommodation_check_out, " +
            "a_photo as accommodation_photo " +
            "from accommodation")
    List<AccommodationDTO> selectAll();

    /*
     * 시리얼 넘버를 변수로 받아 숙소 정보를 반환하는 메서드
     */
    @Select("select s_serialnum as spot_serial_number, " +
            "a_type as accommodation_type, " +
            "a_name as accommodation_name, " +
            "a_pnumber as accommodation_phone_number, " +
            "a_location as accommodation_location, " +
            "a_checkin as accommodation_check_in, " +
            "a_checkout as accommodation_check_out, " +
            "a_photo as accommodation_photo " +
            "from accommodation WHERE S_SERIALNUM = #{serialNumber}")
    AccommodationDTO selectBySerialNumber(String serialNumber);
}
