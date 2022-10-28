package org.ga2.buna.service.editplan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ga2.buna.dao.plandetail.PlanDetailDAO;
import org.ga2.buna.dto.plandetail.PlanDetailDTO;
import org.ga2.buna.service.spot.Spot;
import org.ga2.buna.service.spot.accommodation.Accommodation;
import org.ga2.buna.service.spot.event.Event;
import org.ga2.buna.service.spot.restaurant.Restaurant;
import org.ga2.buna.service.spot.traffic.Traffic;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DetailList {
    private final PlanDetailDAO planDetailDAO;
    private final Traffic traffic;
    private final Accommodation accommodation;
    private final Restaurant restaurant;
    private final Event event;


    public List<Detail> findAllByRowNumber(int rowNumber) {
        List<Detail> detailList = new ArrayList<>();

        for (PlanDetailDTO planDetailDTO: planDetailDAO.selectByRowNumber(rowNumber)) {

            Detail detail = new Detail();
            Spot spot = new Spot();

            detail.setPlanTripDay(planDetailDTO.getPlanTripDay());
            detail.setPlanTripDate(planDetailDTO.getPlanTripDate());
            detail.setPlanSequence(planDetailDTO.getPlanSequence());

            String serialNumber = planDetailDTO.getSpotSerialNumber();
            detail.setSpotSerialNumber(serialNumber);

            switch (serialNumber.charAt(0)) {
                case 'T':
                    spot = traffic.findBySerialNumber(serialNumber);
                    break;
                case 'A':
                    spot = accommodation.findBySerialNumber(serialNumber);
                    break;
                case 'R':
                    spot = restaurant.findBySerialNumber(serialNumber);
                    break;
                case 'E':
                    spot = event.findBySerialNumber(serialNumber);
                    break;
            }
            detail.setSpotName(spot.getSpotName());
            detail.setSpotType(spot.getSpotType());
            detail.setSpotPhoneNumber(spot.getSpotPhoneNumber());
            detail.setSpotLocation(spot.getSpotLocation());
            detail.setSpotPhoto(spot.getSpotPhoto());

            detailList.add(detail);
        }
        return detailList;
    }
}
