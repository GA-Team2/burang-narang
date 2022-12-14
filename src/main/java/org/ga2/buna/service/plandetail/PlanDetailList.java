package org.ga2.buna.service.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.plandetail.PlanDetailRepository;
import org.ga2.buna.dto.plandetail.PlanJoinDTO;
import org.ga2.buna.dto.plandetail.PlanScheduleDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 플랜 상세 정보 얻어오기 위한 클래스
 * @author 장희정
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PlanDetailList implements PlanDetail {

    private final PlanDetailRepository planDetailRepository;

    public Map<String, Object> getDetail(int rownum, String mypage, String pop) {

        Map<String, Object> map = new HashMap<>();
        List<PlanJoinDTO> list = planDetailRepository.getPlanDetail(rownum);

        log.debug(list.toString());

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
