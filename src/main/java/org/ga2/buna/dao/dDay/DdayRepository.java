package org.ga2.buna.dao.dDay;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.index.DDayDTO;
import org.springframework.stereotype.Repository;


/**
 * D-day 기능을위한 클래스
 *
 * @author 한병태
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class DdayRepository {

    private final DdayMapper ddayMapper;

    /**
     * D-day를 표시하기위한 일정 첫번째 날짜를 가져오기위한 메소드
     *
     * @param nick 요청한 닉네임
     * @return DDayBean객체 획득
     */
    public DDayDTO getDday(String nick) {
        return ddayMapper.getDday(nick);
    }
}