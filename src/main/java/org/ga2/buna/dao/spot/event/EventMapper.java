package org.ga2.buna.dao.spot.event;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.spot.event.EventDTO;

import java.util.List;

@Mapper
public interface EventMapper {

    /**
     * 이벤트 정보 리스트를 반환하는 메서드
     *
     * @return 이벤트 객체 리스트
     *
     */
    @Select("SELECT * FROM EVENT")
    List<EventDTO> selectAll();

    /**
     * 시리얼 넘버를 변수로 받아 이벤트 정보 반환하는 메서드
     *
     * @param serialNumber 고유 번호
     * @return 이벤트의 객체
     *
     */
    @Select("SELECT * FROM EVENT WHERE S_SERIALNUM = #{serialNumber}")
    EventDTO selectBySerialNumber(String serialNumber);
}
