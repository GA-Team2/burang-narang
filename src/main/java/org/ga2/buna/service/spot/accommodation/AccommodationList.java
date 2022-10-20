package org.ga2.buna.service.spot.accommodation;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.accommodation.AccommodationDAO;
import org.ga2.buna.dto.spot.accommodation.AccommodationDTO;
import org.ga2.buna.service.spot.Spot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccommodationList implements Accommodation {

    private final AccommodationDAO accommodationDAO;
    private final ConvertAcToSpot convertAcToSpot;

    @Override
    public List<Spot> findAll() {
        List<Spot> spotList = new ArrayList<>();

        for (AccommodationDTO accommodationDTO: accommodationDAO.selectAll()) {
            spotList.add(convertAcToSpot.convert(accommodationDTO));
        }

        return spotList;
    }

    @Override
    public Spot findBySerialNumber(String serialNumber) {
        return convertAcToSpot.convert(accommodationDAO.selectBySerialNumber(serialNumber));
    }
}
