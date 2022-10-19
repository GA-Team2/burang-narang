package org.ga2.buna.controller.plandetail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 플랜 디테일
 */
@Controller
public class PlanDetailController {

    @RequestMapping("/plandetail")
    public String plandetail() {

        return "PlanDetail";
    }

}
