package org.ga2.buna.service.index;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.dDay.DdayRepository;
import org.springframework.stereotype.Service;

/**
 * D-day 인터페이스 구현체
 *
 * @author 한병태
 */
@Service
@AllArgsConstructor
@Slf4j
public class DdayCheckImpl implements DdayCheck {

    private final DdayRepository ddayRepository;

    /**
     * D-day별 출력 문구 설정 메소드
     *
     * @param nick D-day를 요청한 닉네임
     * @return 출력문 리턴
     */
    @Override
    public String getDday(String nick) {
        int dDay = ddayRepository.getDday(nick).getDoDay();
        if (dDay < 0) {
            return "일정이 없습니다.";
        } else if (dDay > 0) {
            return "D-" + dDay;
        } else if (dDay == 0) {
            return "오늘입니다.";
        } else {
            return "오류";
        }
    }
}
