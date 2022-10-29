package org.ga2.buna.dao.dateCheck;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.index.DateCheckDTO;

import java.util.List;

@Mapper
public interface DateCheckMapper {

    @Select("SELECT p_tripdate as plan_tripdate," +
            " datecount FROM DATECOUNT")
    List<DateCheckDTO> getDate();
}
