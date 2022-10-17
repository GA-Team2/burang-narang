package org.ga2.buna.controller;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.TrafficDAO;
import org.ga2.buna.dto.TrafficDTO;
import org.ga2.buna.service.PopularTag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/new")
public class MakePlanController {
    private final PopularTag popularTag;

    private  final TrafficDAO trafficDAO;

    @GetMapping
    public String popularTagList(Model model) {
        model.addAttribute("list", popularTag.findAll());
        model.addAttribute("trafficList", trafficDAO.getTrafficList());
        getSpot();

        return "MakePlan";
    }

    @ResponseBody
    public Map<Integer, Object> getSpot() {
        Map<String, List<TrafficDTO>> spotList = new HashMap<>();
        spotList.put("trafficList", trafficDAO.getTrafficList());

        Map<Integer, Object> returnList = new HashMap<>();
        for (int i = 0; i < spotList.size(); i++) {
            returnList.put(i, spotList.get("trafficList").get(i));
        }

        return returnList;
    }
}
