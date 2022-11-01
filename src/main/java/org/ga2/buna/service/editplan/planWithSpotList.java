package org.ga2.buna.service.editplan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.plandetail.PlanDetailRepository;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.ga2.buna.dto.plandetail.PlanWithSpotDTO;
import org.ga2.buna.dto.spot.SpotDTO;
import org.ga2.buna.service.spot.accommodation.Accommodation;
import org.ga2.buna.service.spot.event.Event;
import org.ga2.buna.service.spot.restaurant.Restaurant;
import org.ga2.buna.service.spot.traffic.Traffic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 플랜 수정 페이지에 출력할 플랜 정보 반환하는 클래스
 *
 * @author 한애채
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class planWithSpotList {
    private final PlanDetailRepository planDetailRepository;
    private final Traffic traffic;
    private final Accommodation accommodation;
    private final Restaurant restaurant;
    private final Event event;

    /**
     * 플랜 수정 페이지에 출력할 플랜 객체 리스트 반환하는 메서드
     * 
     * @param rowNumber 게시물 번호
     * @return 플랜 디테일 정보와 장소 정보 가지는 객체 리스트
     */
    public List<PlanWithSpotDTO> findAllByRowNumber(int rowNumber) {
        List<PlanWithSpotDTO> planWithSpotDTOList = new ArrayList<>();

        for (PlanDetailDTO planDetailDTO : planDetailRepository.selectByRowNumber(rowNumber)) {

            PlanWithSpotDTO planWithSpotDTO = new PlanWithSpotDTO();
            SpotDTO spotDTO = new SpotDTO();

            planWithSpotDTO.setPlanTripDay(planDetailDTO.getPlanTripDay());
            planWithSpotDTO.setPlanTripDate(planDetailDTO.getPlanTripDate());
            planWithSpotDTO.setPlanSequence(planDetailDTO.getPlanSequence());

            String serialNumber = planDetailDTO.getSpotSerialNumber();
            planWithSpotDTO.setSpotSerialNumber(serialNumber);

            switch (serialNumber.charAt(0)) {
                case 'T':
                    spotDTO = traffic.findBySerialNumber(serialNumber);
                    break;
                case 'A':
                    spotDTO = accommodation.findBySerialNumber(serialNumber);
                    break;
                case 'R':
                    spotDTO = restaurant.findBySerialNumber(serialNumber);
                    break;
                case 'E':
                    spotDTO = event.findBySerialNumber(serialNumber);
                    break;
            }
            planWithSpotDTO.setSpotName(spotDTO.getSpotName());
            planWithSpotDTO.setSpotType(spotDTO.getSpotType());
            planWithSpotDTO.setSpotLocation(spotDTO.getSpotLocation());
            planWithSpotDTO.setSpotPhoto(spotDTO.getSpotPhoto());

            planWithSpotDTOList.add(planWithSpotDTO);
        }
        return planWithSpotDTOList;
    }
}
