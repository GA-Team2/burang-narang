package org.ga2.buna.service.spot.traffic;

import org.ga2.buna.dto.spot.traffic.TrafficDTO;
import org.ga2.buna.dto.spot.SpotDTO;
import org.springframework.stereotype.Service;

/**
 * 교통 데이터를 장소 데이터로 전환하는 클래스
 *
 * @author 한애채
 */
@Service
public class TfToSpotList implements TfToSpot {

    /**
     * 교통 데이터를 장소 데이터로 전환하는 클래스
     *
     * @param trafficDTO 교통 데이터 객체
     * @return 장소 데이터 객체
     */
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
