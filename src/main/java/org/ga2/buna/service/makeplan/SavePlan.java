package org.ga2.buna.service.makeplan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@Slf4j
public class SavePlan {
    public void getDate(HttpServletRequest httpServletRequest) {
        String title = httpServletRequest.getParameter("P_title");
        log.info("title = {}", title);
    }
}
