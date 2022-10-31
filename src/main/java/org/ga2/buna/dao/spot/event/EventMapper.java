package org.ga2.buna.dao.spot.event;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.spot.event.EventDTO;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface EventMapper {

    /**
     * 이벤트 정보 리스트를 반환하는 메서드
     *
     * @return 이벤트 객체 리스트
     *
     */
    @Select("select s_serialnum as spot_serial_number, " +
            "e_name as event_name, " +
            "e_venue as event_venue, " +
            "e_pnumber as event_phone_number, " +
            "e_location as event_location, " +
            "e_startdate as event_start_date, " +
            "e_enddate as event_end_date, " +
            "e_photo as event_photo, " +
            "e_url as event_url " +
            "from event")
    List<EventDTO> selectAll();

    /**
     * 시리얼 넘버를 변수로 받아 이벤트 정보 반환하는 메서드
     *
     * @param serialNumber 고유 번호
     * @return 이벤트의 객체
     *
     */
    @Select("select s_serialnum as spot_serial_number, " +
            "e_name as event_name, " +
            "e_venue as event_venue, " +
            "e_pnumber as event_phone_number, " +
            "e_location as event_location, " +
            "e_startdate as event_start_date, " +
            "e_enddate as event_end_date, " +
            "e_photo as event_photo, " +
            "e_url as event_url " +
            "from event WHERE S_SERIALNUM = #{serialNumber}")
    EventDTO selectBySerialNumber(String serialNumber);
}
