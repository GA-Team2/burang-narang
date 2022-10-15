package org.ga2.buna.controller;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.TagDao;
import org.ga2.buna.dto.TagDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TagController {
    private final TagDao tagDao;

    @RequestMapping("/makeplan")
    public String view(Model model) {
        List<TagDto> list = tagDao.listTag();
        model.addAttribute("list", list);

        return "MakePlan";
    }
}
