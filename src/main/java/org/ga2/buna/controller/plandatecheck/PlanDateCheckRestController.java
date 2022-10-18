package org.ga2.buna.controller.plandatecheck;

import lombok.AllArgsConstructor;
import org.ga2.buna.service.datecheck.PlanDateCheckImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class PlanDateCheckRestController {
    private final PlanDateCheckImpl planDateCheck;

    @RequestMapping(value = "check", produces = MediaType.APPLICATION_JSON_VALUE)
    public String datecheck() throws Exception {
        return planDateCheck.getDB();
    }
}
