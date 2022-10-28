package org.ga2.buna.dao.plandetail;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.plandetail.PlanJoinDTO;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;

import java.util.List;

@Mapper
public interface PlanDetailMapper {
    @Select("SELECT P_TRIPDAY as trip_day, P_SEQUENCE as trip_sequence, LOCATION as spot_location FROM PLANDETAILVIEW WHERE P_ROWNUM = #{planRownum}")
    List<SearchInfoDTO> getSearchInfo(int planRownum);


    List<PlanJoinDTO> getPlanDetail(int planRownum);


    @Select("SELECT MAX(P_TRIPDAY) FROM PLANDETAIL WHERE P_ROWNUM = #{planRownum}")
    int getPlanDay(int planRownum);


    List<Integer> getTripDaySequence(int planRownum);
}
