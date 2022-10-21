package org.ga2.buna.service.makeplan;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToTime {

    /* String 형식을 timestamp 형식으로 변환 */
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Timestamp toTime(String dateString) throws ParseException {
        return new Timestamp(((Date)simpleDateFormat.parse(dateString)).getTime());
    }
}
