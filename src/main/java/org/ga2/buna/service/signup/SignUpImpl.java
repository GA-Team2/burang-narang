package org.ga2.buna.service.signup;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.signup.SignUpRepository;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SignUpImpl implements SignUp{

    private final SignUpRepository dao;

    @Override
    public void insertMember(MemberDTO memberDTO) {
        dao.insertMember(memberDTO);
    }
}
