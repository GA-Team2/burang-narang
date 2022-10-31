package org.ga2.buna.service.index;

import lombok.AllArgsConstructor;
import org.ga2.buna.dao.dateCheck.DateCheckRepository;
import org.ga2.buna.dto.index.DateCheckDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanDateCheckImpl implements PlanDateCheck {
    private final DateCheckRepository dateCheckRepository;

    @Override
    public List<DateCheckDTO> getDB(){
        return dateCheckRepository.getDate();
    }
}
