package org.ga2.buna.controller.signup;

import lombok.AllArgsConstructor;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.ga2.buna.service.signup.SignUp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/signup")
@AllArgsConstructor
public class SignUpController {
    private final SignUp signUp;

    @RequestMapping("/ok")
    public String signup(HttpServletRequest request) {
        MemberDTO dto = new MemberDTO();
        dto.setMemberNickname(request.getParameter("memberNickname"));
        dto.setMemberPassword(request.getParameter("memberPassword"));
        dto.setMemberBirthyear(Integer.parseInt(request.getParameter("memberBirthyear")));
        dto.setMemberGender(Integer.parseInt(request.getParameter("memberGender")));
        signUp.insertMember(dto);
        return "redirect:/login";
    }
}
