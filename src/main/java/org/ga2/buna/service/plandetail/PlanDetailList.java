package org.ga2.buna.service.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.PlanDAO;
import org.ga2.buna.dao.plandetail.PlanDetailDAO;
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

    private final PlanDetailDAO planDetailDAO;

    public void execute(Model model) {

        Map<String, Object> param = model.asMap();
        HttpServletRequest request = (HttpServletRequest) param.get("request");
        int rownum = Integer.parseInt(request.getParameter("rownum"));


        String mypage = "";
        String pop = "";
        if (request.getParameter("mypage")!=null) {
            mypage = request.getParameter("mypage");
        }
        if (request.getParameter("pop")!=null) {
            pop = request.getParameter("pop");
        }

        model.addAttribute("rownum", rownum);
        model.addAttribute("mypage", mypage);
        model.addAttribute("pop", pop);

        //전체 여행 기간
        int totaltripday = planDetailDAO.getPlanDay(rownum);
        //여행 일자별로 일정 수 배열에 담기
        int[] seqNum = planDetailDAO.getTripDaySequence(totaltripday, rownum);

        List<PlanJoinDTO> list = planDetailDAO.getPlanDetail(rownum);

        //일정이 이벤트일 때 spotname에 eventname을 세팅
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSpotSerialnum().charAt(0) == 'E') {
                list.get(i).setPlanSpotname(list.get(i).getEventName());
            }
        }

        model.addAttribute("list", list);
        model.addAttribute("totalTripDay", totaltripday);
        model.addAttribute("seqNumber", seqNum);

    }
}
