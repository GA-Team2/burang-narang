package org.ga2.buna.service.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.plandetail.PlanDetailDAO;
import org.ga2.buna.dto.plandetail.PlanJoinDTO;
import org.ga2.buna.dto.plandetail.PlanScheduleDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlanDetailList implements PlanDetail {

    private final PlanDetailDAO planDetailDAO;

    public Map<String, Object> getDetail(int rownum, String mypage, String pop) {

        Map<String, Object> map = new HashMap<>();
        List<PlanJoinDTO> list = planDetailDAO.getPlanDetail(rownum);

        log.info(list.toString());

        //일정이 이벤트일 때 spotname에 eventname을 세팅
        for (PlanJoinDTO pjdto : list) {
            for (PlanScheduleDTO psdto : pjdto.getPlanScheduleDTO()) {
                if (psdto.getSpotSerialnum().charAt(0) == 'E') {
                    psdto.setPlanSpotname(psdto.getEventName());
                }
            }
        }

        map.put("list", list);

        return map;
    }
}
