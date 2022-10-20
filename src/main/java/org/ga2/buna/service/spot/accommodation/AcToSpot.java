package org.ga2.buna.service.spot.accommodation;

import org.ga2.buna.dto.spot.accommodation.AccommodationDTO;
import org.ga2.buna.service.spot.Spot;

public interface AcToSpot {
    Spot convert(AccommodationDTO accommodationDTO);
}
