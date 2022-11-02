package org.ga2.buna.dao.dateCheck;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.index.DateCheckDTO;

import java.util.List;

/**
 * 여행이 계획된 날짜와 날짜별 계획된 여행의 개수를 가져오는 mapper
 *
 * @author 한병태
 */
@Mapper
public interface DateCheckMapper {

    /**
     * 여행이 계획된 날짜와 날짜별 계획된 여행의 개수를 가져오는 메소드
     */
    @Select("SELECT p_tripdate as plan_tripdate," +
            " datecount from datecount")
    List<DateCheckDTO> getDate();
}
