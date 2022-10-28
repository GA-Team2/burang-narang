package org.ga2.buna.dao.dDay;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.index.DDayDTO;

import javax.validation.constraints.NotNull;

@Mapper
public interface DdayMapper {

    @Select("select ifnull(min(datediff(P_FIRSTDATE, curdate())), -1) as do_day from planinfo where M_NICKNAME=#{nick} and P_FIRSTDATE >= curdate()")
    DDayDTO getDday(String nick);
}
