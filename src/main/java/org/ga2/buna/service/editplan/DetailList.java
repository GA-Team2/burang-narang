package org.ga2.buna.service.editplan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.plandetail.PlanDetailRepository;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.ga2.buna.dto.spot.SpotDTO;
import org.ga2.buna.service.spot.accommodation.Accommodation;
import org.ga2.buna.service.spot.event.Event;
import org.ga2.buna.service.spot.restaurant.Restaurant;
import org.ga2.buna.service.spot.traffic.Traffic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DetailList {
    private final PlanDetailRepository planDetailRepository;
    private final Traffic traffic;
    private final Accommodation accommodation;
    private final Restaurant restaurant;
    private final Event event;


    public List<Detail> findAllByRowNumber(int rowNumber) {
        List<Detail> detailList = new ArrayList<>();

        for (PlanDetailDTO planDetailDTO: planDetailRepository.selectByRowNumber(rowNumber)) {

            Detail detail = new Detail();
            SpotDTO spotDTO = new SpotDTO();

            detail.setPlanTripDay(planDetailDTO.getPlanTripDay());
            detail.setPlanTripDate(planDetailDTO.getPlanTripDate());
            detail.setPlanSequence(planDetailDTO.getPlanSequence());

            String serialNumber = planDetailDTO.getSpotSerialNumber();
            detail.setSpotSerialNumber(serialNumber);

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
            detail.setSpotName(spotDTO.getSpotName());
            detail.setSpotType(spotDTO.getSpotType());
            detail.setSpotPhoneNumber(spotDTO.getSpotPhoneNumber());
            detail.setSpotLocation(spotDTO.getSpotLocation());
            detail.setSpotPhoto(spotDTO.getSpotPhoto());

            detailList.add(detail);
        }
        return detailList;
    }
}
