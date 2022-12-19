package org.ga2.buna.service.signup;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.signup.SignUpRepository;
import org.springframework.stereotype.Service;

/**
 * 닉네임 중복체크 인터페이스 구현체
 * 
 * @author 한병태
 */
@Service
@AllArgsConstructor
public class NickCheckImpl implements NickCheck {

    private SignUpRepository signUpRepository;

    /**
     * 닉네임이 존재여부를 판단해 분기점을 마련할 문자열 데이터를 보내는 메소드
     * @param nick 중복체크할 닉네임
     * @return 분기점 마련 문자열 데이터 리턴
     */
    @Override
    public String nickCheck(String nick) {
        if (signUpRepository.confirmID(nick).size() != 0) {
            return "exist";
        } else {
            return "available";
        }
    }
}
