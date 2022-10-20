package org.ga2.buna.service.spot.traffic;

import org.ga2.buna.dto.spot.traffic.TrafficDTO;
import org.ga2.buna.service.spot.Spot;
import org.springframework.stereotype.Service;

@Service
public class TfToSpotList implements TfToSpot {
    @Override
    public Spot convert(TrafficDTO trafficDTO) {
        Spot spot = new Spot();
        spot.setSpotSerialNumber(trafficDTO.getSpotSerialNumber());
        spot.setSpotType(trafficDTO.getTrafficType());
        spot.setSpotName(trafficDTO.getTrafficName());
        spot.setSpotPhoneNumber(trafficDTO.getTrafficPhoneNumber());
        spot.setSpotLocation(trafficDTO.getTrafficLocation());
        spot.setSpotPhoto(trafficDTO.getTrafficPhoto());
        spot.setSpotStartTime("");
        spot.setSpotEndTime("");

        return spot;
    }
}
