package org.ga2.buna.dao.login;

import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.memberinfo.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Repository
public class LoginDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<MemberDTO> userCheck(String nick) {
        System.out.println(nick);
        String sql = "select m_nickname, m_password from MEMBERINFO where m_nickname = ?";

        List<MemberDTO> list = this.jdbcTemplate.query(sql, (resultSet, rowNum) -> {
           MemberDTO memberDTO = new MemberDTO();
           memberDTO.setMemberNickname(resultSet.getString(1));
           memberDTO.setMemberPassword(resultSet.getString(2));
           return memberDTO;
        }, nick);
        return list;
    }
}
