package org.ga2.buna.service.signup;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.signup.SignUpDAO;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SignUpImpl implements SignUp{

    private final SignUpDAO dao;

    @Override
    public void insertMember(MemberDTO memberDTO) {
        dao.insertMember(memberDTO);
    }
}
