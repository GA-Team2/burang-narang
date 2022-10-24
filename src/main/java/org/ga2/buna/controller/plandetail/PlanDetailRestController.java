package org.ga2.buna.controller.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;
import org.ga2.buna.service.makeplan.SearchingSpotInfo;
import org.ga2.buna.service.plandetail.Like;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/detail")
@Slf4j
public class PlanDetailRestController {
    private final SearchingSpotInfo searchingSpotInfo;
    private final Like like;

    @GetMapping(value = "/all")
    public List<SearchInfoDTO> searchSpotInfo(int rownum) {
        log.debug("rownum={}", rownum);
        return searchingSpotInfo.getInfo(rownum);
    }


    @GetMapping("/likecheck")
    public int getlikeNum(HttpServletRequest request, HttpSession session) {

        int rownum = Integer.parseInt(request.getParameter("rownum"));
        log.info("ajax에서 받아온 rownum값 => {}", rownum);
        log.info("likecheck => {}", like.likeInsert(session, rownum));
        return like.likeInsert(session, rownum);
    }



}
