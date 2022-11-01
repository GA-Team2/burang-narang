package org.ga2.buna.service.spot.event;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * 타임스탬프를 문자열로 변환하는 클래스
 *
 * @author 한애채
 * */
@Service
public class TimeToStringFormat implements TimeToString {
    /**
     * 타임 스탬프를 문자열로 변환하는 메서드
     *
     * @param timestamp 타임스탬프를 데이터 타입으로 가지는 시간 변수
     * @return 문자열로 변환해 반환
     * */
    @Override
    public String toString(Timestamp timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(timestamp);
    }
}
