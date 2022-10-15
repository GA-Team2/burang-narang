package org.ga2.buna.controller;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.TrafficDAO;
import org.ga2.buna.dto.TrafficDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class trafficController {
    private  final TrafficDAO trafficDAO;

    @RequestMapping(value = "/makeplan/spotlist", method = RequestMethod.GET)
    public String viewTraffic(Model model, HttpServletRequest request) {
        List<TrafficDTO> trafficList = trafficDAO.getTrafficList();
        model.addAttribute("trafficList", trafficList);

        model.addAttribute("spot", request);

        return "SpotList";
    }
}
