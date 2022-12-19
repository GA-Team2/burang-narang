package org.ga2.buna.dao.dateCheck;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.index.DateCheckDTO;
import org.springframework.stereotype.Repository;

/**
 * mapper로부터 가져온 DB데이터를 담아두는 Repository 클래스
 *
 * @author 한병태
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class DateCheckRepository {

    /**
     * mapper 필드 선언
     */
    private final DateCheckMapper dateCheckMapper;

    /**
     * DateCheckDto를 담아둔 List를 가져오는 메소드
     *
     * @return mapper로부터 가져온 List데이터를 리턴
     */
    public List<DateCheckDTO> getDate() {
        return dateCheckMapper.getDate();
    }
}