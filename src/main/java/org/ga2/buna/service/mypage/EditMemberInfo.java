package org.ga2.buna.service.mypage;

import org.ga2.buna.dto.memberinfo.MemberDTO;


public interface EditMemberInfo {
    void updateMember(MemberDTO memberDTO, String nick);
}
