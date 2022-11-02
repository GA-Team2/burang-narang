package org.ga2.buna.controller.makeplan;

import lombok.AllArgsConstructor;
import org.ga2.buna.service.makeplan.PopularTag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 플랜 작성 페이지
 *
 * @author 김규빈, 한애채
 */
@Controller
@AllArgsConstructor
@RequestMapping("/new")
public class MakePlanController {
    private final PopularTag popularTag;

    /**
     * @param model   페이지에 출력할 데이터
     * @param session 회원 정보 받아오는 세션
     * @return 플랜 작성 페이지
     */
    @GetMapping
    public String popularTagList(Model model, HttpSession session) {
        model.addAttribute("list", popularTag.findAll());
        model.addAttribute("nick", session.getAttribute("nick_s"));

        return "MakePlan";
    }
}
