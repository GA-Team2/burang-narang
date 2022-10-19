package org.ga2.buna.controller.index;

import lombok.AllArgsConstructor;
import org.ga2.buna.dto.DateCheckBean;
import org.ga2.buna.service.datecheck.PlanDateCheck;
import org.ga2.buna.service.datecheck.PlanDateCheckImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class PlanDateCheckRestController {
    private final PlanDateCheck planDateCheck;

    @RequestMapping(value = "check")
    public List<DateCheckBean> datecheck() throws Exception {
        return planDateCheck.getDB();
    }
}
