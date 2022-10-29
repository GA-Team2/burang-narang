package org.ga2.buna.controller.index;

import lombok.AllArgsConstructor;
import org.ga2.buna.dto.index.DateCheckDTO;
import org.ga2.buna.service.index.PlanDateCheck;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 혼잡도 용 ajax 데이터 Controller
 */
@RestController
@AllArgsConstructor
@RequestMapping("/")
public class HomeRestController {
    private final PlanDateCheck planDateCheck;

    /**
     * DB에 저장된 날짜별 여행계획 수
     * @return 날짜별 여행계획 수 List구조로 리턴
     */
    @RequestMapping(value = "check")
    public List<DateCheckDTO> datecheck() {
        return planDateCheck.getDB();
    }
}
