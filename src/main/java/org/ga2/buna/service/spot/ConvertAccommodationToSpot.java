package org.ga2.buna.service.spot;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.accommodation.AccommodationDAO;
import org.ga2.buna.dto.spot.accommodation.AccommodationDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConvertAccommodationToSpot implements AccommodationToSpot{
    private final AccommodationDAO accommodationDAO;

    @Override
    public List<Spot> findAll() {
        List<Spot> spotList = new ArrayList<>();

        for (AccommodationDTO accommodationDTO: accommodationDAO.selectAll()) {
            spotList.add(convertToSpot(accommodationDTO));
        }

        return spotList;
    }

    @Override
    public Spot findBySerialNumber(String serialNumber) {
        return convertToSpot(accommodationDAO.selectBySerialNumber(serialNumber));
    }

    public Spot convertToSpot(AccommodationDTO accommodationDTO) {
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
