package org.ga2.buna.controller.signup;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.ga2.buna.service.signup.SignUp;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * 회원가입 Controller
 */
@Controller
@RequestMapping("/signup")
@AllArgsConstructor
@Slf4j
public class SignUpController {

    //회원가입 서비스 계층 필드(생성자로 의존주입)
    private final SignUp signUp;

    /**
     * 회원가입 form 및 validation 유효성 검사
     * @param dto 회원정보를 넣을 dto
     * @param result validation 검사의 결과값을 저장한 객체
     * @return validation 검사결과 error가 출력되면 회원가입 form으로 리턴. error가 없을 경우 로그인 페이지로 리턴
     */
    @RequestMapping("/ok")
    public String signup(@ModelAttribute @Valid MemberDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result);
            return "redirect:/signup";
        } else {
            System.out.println(dto.getMemberNickname());
            signUp.insertMember(dto);
            return "redirect:/login";
        }
    }
}
