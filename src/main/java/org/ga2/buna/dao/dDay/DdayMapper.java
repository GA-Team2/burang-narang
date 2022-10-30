package org.ga2.buna.dao.dDay;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.index.DDayDTO;

@Mapper
public interface DdayMapper {

    @Select("select ifnull(min(datediff(P_FIRSTDATE, curdate())), -1) as do_day from planinfo where m_nickname=#{nick} and p_firstdate >= curdate()")
    DDayDTO getDday(String nick);
}
