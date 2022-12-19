package org.ga2.buna.controller.signup;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.service.signup.NickCheck;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 닉네임 중복체크 ajax용 Controller
 *
 * @author 한병태
 */
@RestController
@AllArgsConstructor
@Slf4j
public class SignUpRestController {

    //닉네임 중복체크 서비스 계층 필드 선언
    private final NickCheck nickCheck;

    /**
     * 중복체크를 위한 분기점 생성 데이터 Controller
     *
     * @param nick 닉네임 중복체크 대상
     * @return 중복체크 분기점 생성 데이터 리턴
     */
    @RequestMapping("signup/check")
    @ResponseStatus(HttpStatus.CREATED)
    public String nickCheck(@RequestBody String nick) {
        return nickCheck.nickCheck(nick);
    }
}
