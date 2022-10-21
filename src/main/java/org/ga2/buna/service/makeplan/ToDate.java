package org.ga2.buna.service.makeplan;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class ToDate {
    public Timestamp toDate(String dateString) throws ParseException {
        /* String 형식을 timestamp 형식으로 변환 */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return new Timestamp(((Date)simpleDateFormat.parse(dateString)).getTime());
    }

    public Timestamp getTripdate(int tripDay, Timestamp firstTripDate) {
        /* 현재 여행 날짜 계산 (yyyy-MM-dd) */
        Calendar cal = Calendar.getInstance();
        cal.setTime(firstTripDate);

        Timestamp tripDate = firstTripDate;
        /* 첫째날이면 firstdate, 마지막 날이면 lastdate */
        if (tripDay == 1)
            tripDate = firstTripDate;
        else {
            cal.add(Calendar.DATE, (tripDay - 1));
            tripDate = new Timestamp(cal.getTime().getTime());
        }
        return tripDate;
    }

    /* 테스트 필요 */
    public int getTripDays(Timestamp firstTripDate, Timestamp lastTripDate) {
        long tripDays = (lastTripDate.getTime() - firstTripDate.getTime()) / (24 * 60 * 60 * 1000);
        return (int)tripDays;
    }
}
