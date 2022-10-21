package org.ga2.buna.service.index;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.dateCheck.DateCheckDAO;
import org.ga2.buna.dto.DateCheckBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanDateCheckImpl implements PlanDateCheck {
    private final DateCheckDAO dateCheckDAO;

    @Override
    public List<DateCheckBean> getDB(){
        return dateCheckDAO.getDate();
    }
}
