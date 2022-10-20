package org.ga2.buna.service.spot;

import org.ga2.buna.dto.spot.accommodation.AccommodationDTO;

import java.util.List;

public interface AccommodationToSpot {
    List<Spot> findAll();
    Spot findBySerialNumber(String serialNumber);
    Spot convertToSpot(AccommodationDTO accommodationDTO);
}
