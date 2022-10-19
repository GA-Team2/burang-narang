package org.ga2.buna.service.index;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.DDayDBBean;
import org.ga2.buna.dto.DDayBean;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Map;

@Service
@AllArgsConstructor
public class DdayCheckImpl implements DdayCheck{

    private final DDayDBBean dDayDBBean;

    @Override
    public String getDday(String nick){
        int dDay = dDayDBBean.getDday(nick).getDDay();
        String empty = dDayDBBean.getDday(nick).getEmpty();
        if (empty == null || dDay < 0){
            return "일정이 없습니다.";
        } else if(dDay > 0){
            return  "D-" + dDay;
        } else if(dDay == 0){
            return  "오늘입니다.";
        } else {
            return "오류";
        }
    }
}
