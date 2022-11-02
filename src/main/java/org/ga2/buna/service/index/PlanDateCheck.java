package org.ga2.buna.service.index;

import org.ga2.buna.dto.index.DateCheckDTO;

import java.util.List;

/**
 * 혼잡도 인터페이스
 *
 * @author 한병태
 */
public interface PlanDateCheck {
    List<DateCheckDTO> getDB();
}
