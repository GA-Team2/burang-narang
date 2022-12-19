package org.ga2.buna.controller.login;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.ga2.buna.service.login.Login;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 로그인 분기점 생성 데이터 Controller
 * @author 한병태
 */
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/login")
public class LoginRestController {
    private final Login login;

    /**
     * 로그인 분기점 생성
     * @param memberDTO form에서 가져온 회원정보를 담아두는 회원정보 DTO
     * @return 회원정보가 일치하지 않을 경우 상태코드 200과 분기점 생성 데이터 반환. 회원정보가 일치할 경우 상태코드 201 반환
     */
    @RequestMapping("/check")
    public HttpEntity<String> loginOk(@RequestBody MemberDTO memberDTO) {
        log.debug(memberDTO.getMemberNickname());
        String check = login.Login(memberDTO.getMemberNickname(), memberDTO.getMemberPassword());
        if (check.equals("OK")) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(check, HttpStatus.OK);
        }
    }
}
