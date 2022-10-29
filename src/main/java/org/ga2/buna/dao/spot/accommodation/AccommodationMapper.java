package org.ga2.buna.dao.spot.accommodation;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.spot.accommodation.AccommodationDTO;

import java.util.List;

@Mapper
public interface AccommodationMapper {
    /**
     * 숙소 정보 리스트를 반환하는 메서드
     *
     * @return 숙소 객체 리스트
     */
    @Select("SELECT * FROM ACCOMMODATION")
    List<AccommodationDTO> selectAll();

    /**
     * 시리얼 넘버를 변수로 받아 숙소 정보를 반환하는 메서드
     *
     * @param serialNumber 장소 고유 번호
     * @return 숙소 객체
     *
     */
    @Select("SELECT * FROM ACCOMMODATION WHERE S_SERIALNUM = #{serialNumber}")
    AccommodationDTO selectBySerialNumber(String serialNumber);
}
