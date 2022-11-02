package org.ga2.buna.service.signup;

import org.ga2.buna.dto.memberinfo.MemberDTO;

/**
 * 회원가입 인터페이스
 * 
 * @author 한병태
 */
public interface SignUp {
    void insertMember(MemberDTO memberDTO);
}
