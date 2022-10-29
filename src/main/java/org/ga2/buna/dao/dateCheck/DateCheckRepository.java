package org.ga2.buna.dao.dateCheck;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dto.index.DateCheckDTO;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class DateCheckRepository {

    private final DateCheckMapper dateCheckMapper;

    public List<DateCheckDTO> getDate() {
        return dateCheckMapper.getDate();
    }
}