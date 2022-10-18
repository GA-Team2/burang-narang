package org.ga2.buna.service.mypage;

import org.ga2.buna.dto.MemberDTO;
import org.springframework.ui.Model;

import java.util.List;

public interface MemberInfo {
    public List<MemberDTO> list(Model model);
}
