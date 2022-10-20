package org.ga2.buna.service.spot.accommodation;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dto.spot.accommodation.AccommodationDTO;
import org.ga2.buna.service.spot.Spot;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConvertAcToSpot implements AcToSpot {
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
