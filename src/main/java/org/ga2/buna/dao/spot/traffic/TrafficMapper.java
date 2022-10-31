package org.ga2.buna.dao.spot.traffic;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.spot.traffic.TrafficDTO;

import java.util.List;

@Mapper
public interface TrafficMapper {

    /**
     * 교통 정보 리스트를 반환하는 메서드
     *
     * @return 교통 객체 리스트
     *
     */
    @Select("select s_serialnum as spot_serial_number, " +
            "tf_type as traffic_type, " +
            "tf_name as traffic_name, " +
            "tf_pnumber as traffic_phone_number, " +
            "tf_location as traffic_location, " +
            "tf_photo as traffic_photo " +
            "from traffic")
    List<TrafficDTO> selectAll();

    /**
     * 시리얼 넘버 변수를 이용해 교통 정보를 반환하는 메서드
     *
     * @param serialNumber 장소 고유 번호
     * @return 교통 객체
     *
     */
    @Select("select s_serialnum as spot_serial_number, " +
            "tf_type as traffic_type, " +
            "tf_name as traffic_name, " +
            "tf_pnumber as traffic_phone_number, " +
            "tf_location as traffic_location, " +
            "tf_photo as traffic_photo " +
            "from traffic WHERE S_SERIALNUM = #{serialNumber}")
    TrafficDTO selectBySerialNumber(String serialNumber);
}
