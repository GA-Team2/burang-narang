package org.ga2.buna.controller;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.TrafficDAO;
import org.ga2.buna.dto.TrafficDTO;
import org.ga2.buna.service.PopularTag;
import org.json.JSONArray;
import org.json.JSONObject;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.service.InitAllMapImpl;
import org.ga2.buna.service.PopularTag;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping("/new")
public class MakePlanController {
    private final PopularTag popularTag;
    private final InitAllMapImpl initAllMap;

    private  final TrafficDAO trafficDAO;

    @RequestMapping
    public String popularTagList(Model model) {
        model.addAttribute("list", popularTag.findAll());
        model.addAttribute("trafficList", trafficDAO.getTrafficList());

        return "MakePlan";
    }

    /*@ResponseBody
    @GetMapping
    // @WebServlet(urlPatterns = "/spotlist")
    public String getSpot() throws Exception {
        List<TrafficDTO> trafficDTOList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i < trafficDTOList.size(); i++) {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("spotName", trafficDTOList.get(i).getTrafficName());
            jsonObject.put("spotType", trafficDTOList.get(i).getTrafficType());

            jsonArray.put(jsonObject);
        }

        return jsonArray.toString();
    }*/

    @GetMapping(value = "/1", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String ajaxTest() throws Exception {
        return initAllMap.get();
    }
}
