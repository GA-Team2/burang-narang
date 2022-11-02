package org.ga2.buna.service.index;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.dateCheck.DateCheckRepository;
import org.ga2.buna.dto.index.DateCheckDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 혼잡도 인터페이스 구현체
 *
 * @author 한병태
 */
@Service
@AllArgsConstructor
public class PlanDateCheckImpl implements PlanDateCheck {
    private final DateCheckRepository dateCheckRepository;

    /**
     * 혼잡도 데이터 메소드
     * @return 날짜와 여행 개수가 담겨있는 DTO타입의 List 리턴
     */
    @Override
    public List<DateCheckDTO> getDB() {
        return dateCheckRepository.getDate();
    }
}
