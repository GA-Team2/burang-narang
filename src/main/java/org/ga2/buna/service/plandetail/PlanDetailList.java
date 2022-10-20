package org.ga2.buna.service.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.PlanDAO;
import org.ga2.buna.dto.plandetail.PlanJoinDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlanDetailList implements PlanDetail {

    private final PlanDAO planDAO;

    public void execute(Model model) {

        Map<String, Object> param = model.asMap();
        HttpServletRequest request = (HttpServletRequest) param.get("request");
        int rownum = Integer.parseInt(request.getParameter("rownum"));

        //전체 여행 기간
        int totaltripday = planDAO.getPlanDay(rownum);
        //여행 일자별로 일정 수 배열에 담기
        int[] seqNum = planDAO.getTripDaySequence(totaltripday, rownum);

        List<PlanJoinDTO> list = planDAO.getPlanDetail(rownum);

        model.addAttribute("list", list);
        model.addAttribute("totalTripDay", totaltripday);
        model.addAttribute("seqNumber", seqNum);

    }
}
