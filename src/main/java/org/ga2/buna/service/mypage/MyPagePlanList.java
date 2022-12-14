package org.ga2.buna.service.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.planinfo.PlanInfoRepository;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * 마이페이지 플랜 목록 출력을 위한 클래스
 * @author 장희정
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MyPagePlanList implements MyPagePlan {

    private final PlanInfoRepository planInfoRepository;

    @Override
    public List<PlanInfoDTO> list(Map<String, Object> map, String nick) {

        List<PlanInfoDTO> list = planInfoRepository.getPlanInfo(nick);

        //날짜 포맷 변환
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] firstDate = new String[list.size()];
        String[] lastDate = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            firstDate[i] = sdf.format(list.get(i).getPlanFirstDate());
            lastDate[i] = sdf.format(list.get(i).getPlanLastDate());
        }
        
        map.put("firstDate", firstDate);
        map.put("lastDate", lastDate);

        return list;
    }
}
