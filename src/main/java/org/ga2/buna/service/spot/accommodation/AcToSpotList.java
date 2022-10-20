package org.ga2.buna.service.spot.accommodation;

import org.ga2.buna.dto.spot.accommodation.AccommodationDTO;
import org.ga2.buna.service.spot.Spot;
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
    public Spot convert(AccommodationDTO accommodationDTO) {
        Spot spot = new Spot();
        spot.setSpotSerialNumber(accommodationDTO.getSpotSerialNumber());
        spot.setSpotType(accommodationDTO.getAccommodationType());
        spot.setSpotName(accommodationDTO.getAccommodationName());
        spot.setSpotPhoneNumber(accommodationDTO.getAccommodationPhoneNumber());
        spot.setSpotLocation(accommodationDTO.getAccommodationLocation());
        spot.setSpotPhoto(accommodationDTO.getAccommodationPhoto());
        spot.setSpotStartTime(accommodationDTO.getAccommodationCheckIn());
        spot.setSpotEndTime(accommodationDTO.getAccommodationCheckOut());
        return spot;
    }
}
