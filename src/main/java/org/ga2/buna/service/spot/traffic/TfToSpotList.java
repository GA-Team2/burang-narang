package org.ga2.buna.service.spot.traffic;

import org.ga2.buna.dto.spot.traffic.TrafficDTO;
import org.ga2.buna.dto.spot.SpotDTO;
import org.springframework.stereotype.Service;

@Service
public class TfToSpotList implements TfToSpot {
    @Override
    public SpotDTO convert(TrafficDTO trafficDTO) {
        SpotDTO spotDTO = new SpotDTO();
        spotDTO.setSpotSerialNumber(trafficDTO.getSpotSerialNumber());
        spotDTO.setSpotType(trafficDTO.getTrafficType());
        spotDTO.setSpotName(trafficDTO.getTrafficName());
        spotDTO.setSpotPhoneNumber(trafficDTO.getTrafficPhoneNumber());
        spotDTO.setSpotLocation(trafficDTO.getTrafficLocation());
        spotDTO.setSpotPhoto(trafficDTO.getTrafficPhoto());
        spotDTO.setSpotStartTime("");
        spotDTO.setSpotEndTime("");

        return spotDTO;
    }
}
