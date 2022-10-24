package org.ga2.buna.controller.index;

import lombok.AllArgsConstructor;
import org.ga2.buna.dto.index.DateCheckBean;
import org.ga2.buna.service.index.PlanDateCheck;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class HomeRestController {
    private final PlanDateCheck planDateCheck;

    @RequestMapping(value = "check")
    public List<DateCheckBean> datecheck() throws Exception {
        return planDateCheck.getDB();
    }
}
