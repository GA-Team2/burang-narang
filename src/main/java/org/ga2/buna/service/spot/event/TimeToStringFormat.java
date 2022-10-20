package org.ga2.buna.service.spot.event;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Service
public class TimeToStringFormat implements TimeToString {
    @Override
    public String convert(Timestamp timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(timestamp);
    }
}
