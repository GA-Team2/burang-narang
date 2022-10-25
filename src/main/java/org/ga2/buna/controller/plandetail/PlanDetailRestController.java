package org.ga2.buna.controller.plandetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.plandetail.SearchInfoDTO;
import org.ga2.buna.service.mypage.SearchingSpotInfo;
import org.ga2.buna.service.plandetail.Like;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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


    /**
     * 추천 기능
     */
    @GetMapping("/likecheck")
    public Map<String, Object> getlikeNum(int rownum, HttpSession session) {
        String nick = (String) session.getAttribute("nick_s");
        return like.likeInsert(nick, rownum);
    }



}
