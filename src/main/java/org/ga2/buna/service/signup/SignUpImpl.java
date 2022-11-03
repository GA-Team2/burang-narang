package org.ga2.buna.service.signup;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.signup.SignUpRepository;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.stereotype.Service;

/**
 * 회원가입 인터페이스 구현체
 * 
 * @author 한병태
 */
@Service
@AllArgsConstructor
public class SignUpImpl implements SignUp {

    private final SignUpRepository signUpRepository;

    /**
     * 회원가입 메소드
     * @param memberDTO 회원가입할 회원정보DTO
     */
    @Override
    public void insertMember(MemberDTO memberDTO) {
        signUpRepository.insertMember(memberDTO);
    }
}
