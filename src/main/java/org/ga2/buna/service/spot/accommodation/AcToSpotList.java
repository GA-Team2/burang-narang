package org.ga2.buna.service.spot.accommodation;

import org.ga2.buna.dto.spot.accommodation.AccommodationDTO;
import org.ga2.buna.dto.spot.SpotDTO;
import org.springframework.stereotype.Service;

/*
 * 숙소 데이터를 장소 데이터로 전환하는 클래스
 * @author 한애채
 * */
@Service
public class AcToSpotList implements AcToSpot {
    /*
     * 숙소 데이터를 장소 데이터로 전환
     *
     * @param accommodationDTO 숙소 데이터
     * @return 장소 데이터
     * */
    @Override
    public SpotDTO convert(AccommodationDTO accommodationDTO) {
        SpotDTO spotDTO = new SpotDTO();
        spotDTO.setSpotSerialNumber(accommodationDTO.getSpotSerialNumber());
        spotDTO.setSpotType(accommodationDTO.getAccommodationType());
        spotDTO.setSpotName(accommodationDTO.getAccommodationName());
        spotDTO.setSpotPhoneNumber(accommodationDTO.getAccommodationPhoneNumber());
        spotDTO.setSpotLocation(accommodationDTO.getAccommodationLocation());
        spotDTO.setSpotPhoto(accommodationDTO.getAccommodationPhoto());
        spotDTO.setSpotStartTime(accommodationDTO.getAccommodationCheckIn());
        spotDTO.setSpotEndTime(accommodationDTO.getAccommodationCheckOut());
        return spotDTO;
    }
}
