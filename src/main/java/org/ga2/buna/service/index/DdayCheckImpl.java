package org.ga2.buna.service.index;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.dDay.DdayDAO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class DdayCheckImpl implements DdayCheck{

    private final DdayDAO ddayDAO;

    @Override
    public String getDday(String nick){
        int dDay = ddayDAO.getDday(nick).getDoDay();
        String empty = ddayDAO.getDday(nick).getNullProtect();
        if (dDay < 0){
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
