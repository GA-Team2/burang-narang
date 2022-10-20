package org.ga2.buna.service.spot;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.traffic.TrafficDAO;
import org.ga2.buna.dto.spot.traffic.TrafficDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConvertTrafficToSpot implements TrafficToSpot {
    private final TrafficDAO trafficDAO;

    @Override
    public List<Spot> convertAll() {
        List<Spot> spotList = new ArrayList<>();

        for (TrafficDTO trafficDTO: trafficDAO.selectAll()) {
            Spot spot = new Spot();
            spot.setSpotSerialNumber(trafficDTO.getSpotSerialNumber());
            spot.setSpotType(trafficDTO.getTrafficType());
            spot.setSpotName(trafficDTO.getTrafficName());
            spot.setSpotPhoneNumber(trafficDTO.getTrafficPhoneNumber());
            spot.setSpotLocation(trafficDTO.getTrafficLocation());
            spot.setSpotPhoto(trafficDTO.getTrafficPhoto());
            spot.setSpotStartTime("");
            spot.setSpotEndTime("");

            spotList.add(spot);
        }

        return spotList;
    }
}
