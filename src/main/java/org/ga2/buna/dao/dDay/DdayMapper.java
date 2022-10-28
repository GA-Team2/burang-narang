package org.ga2.buna.dao.dDay;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.index.DDayDTO;

import javax.validation.constraints.NotNull;

@Mapper
public interface DdayMapper {

    @Select("select min(datediff(P_FIRSTDATE, curdate())) as do_day, min(datediff(P_FIRSTDATE, curdate())) as null_protect from planinfo where M_NICKNAME=#{nick} and P_FIRSTDATE >= curdate()")
    DDayDTO getDday(String nick);
}
