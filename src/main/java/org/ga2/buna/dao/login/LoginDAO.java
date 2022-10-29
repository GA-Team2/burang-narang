package org.ga2.buna.dao.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class LoginDAO {

    private final LoginMapper loginMapper;

    public List<MemberDTO> userCheck(String nick) {
        return loginMapper.userCheck(nick);
    }
}
