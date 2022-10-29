package org.ga2.buna.dao.dateCheck;

import java.util.List;
import javax.sql.DataSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.index.DateCheckDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class DateCheckDAO {

    private final DateCheckMapper dateCheckMapper;

    public List<DateCheckDTO> getDate() {
        return dateCheckMapper.getDate();
    }
}