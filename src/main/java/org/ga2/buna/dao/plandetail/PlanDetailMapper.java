package org.ga2.buna.dao.plandetail;

import org.apache.ibatis.annotations.*;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.ga2.buna.dto.plandetail.PlanJoinDTO;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;

import java.util.List;

@Mapper
public interface PlanDetailMapper {
    @Select("SELECT P_TRIPDAY as trip_day, P_SEQUENCE as trip_sequence, LOCATION as spot_location FROM plandetailview WHERE P_ROWNUM = #{planRownum} ORDER BY trip_day, trip_sequence")
    List<SearchInfoDTO> getSearchInfo(int planRownum);

    //총 여행일자 구하는 메서드
    @Select("SELECT MAX(P_TRIPDAY) FROM plandetail WHERE P_ROWNUM = #{planRownum}")
    Integer getPlanDay(int planRownum);

    //디테일 페이지 필요한 요소 얻어오는 메서드
    List<PlanJoinDTO> getPlanDetail(int planRownum);

    /**
     * 게시물 번호를 변수로 받아 해당 게시물의 플랜 Detail 정보를 반환하는 메서드
     *
     * @param rowNumber 게시물 번호
     * @return 플랜 디테일 객체
     */
    @Select("SELECT p_rownum as plan_row_number, " +
            "P_TRIPDAY AS plan_trip_day, " +
            "p_tripdate as plan_trip_date, " +
            "p_sequence as plan_sequence, " +
            "s_serialnum as spot_serial_number, " +
            "p_spotname as plan_spot_name " +
            "FROM plandetail WHERE P_ROWNUM = #{rowNumber} " +
            "ORDER BY P_TRIPDAY, P_SEQUENCE")
    List<PlanDetailDTO> selectByRowNumber(int rowNumber);

    /**
     * 플랜 Detail 객체와, 게시물 번호 변수를 받아 plandetail 정보를 insert하는 메서드
     *
     * @param planDetailDTO 플랜 디테일 객체
     * @param rowNumber     게시물 번호
     */
    @Insert("INSERT INTO plandetail " +
            "VALUES(#{rowNumber}, " +
            "#{planDetailDTO.planTripDay}, " +
            "#{planDetailDTO.planTripDate}, " +
            "#{planDetailDTO.planSequence}, " +
            "#{planDetailDTO.spotSerialNumber}, " +
            "#{planDetailDTO.planSpotName})")
    void insert(@Param("planDetailDTO") PlanDetailDTO planDetailDTO, @Param("rowNumber") int rowNumber);

    /**
     * 게시물 번호를 변수로 받아 해당 게시물의 플랜 Detail 정보를 삭제하는 메서드
     *
     * @param rowNumber 게시물 번호
     */
    @Delete("DELETE FROM plandetail WHERE P_ROWNUM = #{rowNumber}")
    void delete(int rowNumber);
}
