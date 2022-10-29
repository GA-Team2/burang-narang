package org.ga2.buna.dao.spot.spotdetail;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.spot.spotdetail.SpotDetailDTO;

import java.util.List;

@Mapper
public interface SpotDetailMapper {
    /**
     * 장소 이름을 변수로 받아 해당 이름이 장소 디테일에 존재한다면 장소 디테일의 정보를 반환하는 메서드
     *
     * @param spotName 장소 이름
     * @return 장소 객체 리스트
     */
    @Select("SELECT S_SERIALNUM as spot_serial_number " +
            "FROM spotdetail WHERE S_NAME LIKE CONCAT(‘%’, #{spotName}, ‘%’)")
    List<SpotDetailDTO> selectBySpotNameLike(String spotName);
}
