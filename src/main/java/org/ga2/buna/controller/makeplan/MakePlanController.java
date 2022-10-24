package org.ga2.buna.controller.makeplan;

import lombok.AllArgsConstructor;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.ga2.buna.dto.planinfo.PlanInfoDTO;
import org.ga2.buna.service.makeplan.PopularTag;
import org.ga2.buna.service.makeplan.SavePlan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/new")
public class MakePlanController {
    private final PopularTag popularTag;
    private final SavePlan savePlan;

    @GetMapping
    public String popularTagList(Model model) {
        model.addAttribute("list", popularTag.findAll());

        return "MakePlan";
    }
}
