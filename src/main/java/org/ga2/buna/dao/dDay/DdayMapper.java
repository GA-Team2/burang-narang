package org.ga2.buna.dao.dDay;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ga2.buna.dto.index.DDayDTO;

/**
 * D-day를 가져오는 mapper클래스
 *
 * @author 한병태
 */
@Mapper
public interface DdayMapper {

    /**
     * 가장 가까운 계획의 여행 시작 날짜와 현재 날짜의 차이를 DB로부터 가져오는 쿼리메소드
     *
     * @param nick 요청한 닉네임
     */
    @Select("select ifnull(min(datediff(P_FIRSTDATE, curdate())), -1) as do_day from planinfo where m_nickname=#{nick} and p_firstdate >= curdate()")
    DDayDTO getDday(String nick);
}
