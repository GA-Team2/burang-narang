package org.ga2.buna.dao.spot.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.spot.event.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.sql.DataSource;

/**
 * 이벤트에 접근하는 클래스 => eventListDAO와 병합 필요!!
 *
 * @author 한애채
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class EventRepository {

    private final EventMapper eventMapper;

    /**
     * 이벤트 정보 리스트를 반환하는 메서드
     *
     * @return 이벤트 객체 리스트
     */
    public List<EventDTO> selectAll() {
        return eventMapper.selectAll();
    }

    /**
     * 시리얼 넘버를 변수로 받아 이벤트 정보 반환하는 메서드
     *
     * @param serialNumber 고유 번호
     * @return 이벤트의 객체
     */
    public EventDTO selectBySerialNumber(String serialNumber) {
        return eventMapper.selectBySerialNumber(serialNumber);
    }
}