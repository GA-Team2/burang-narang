package org.ga2.buna.service.spot.accommodation;

import org.ga2.buna.dto.spot.SpotDTO;
import org.ga2.buna.dto.spot.accommodation.AccommodationDTO;

public interface AcToSpot {
    SpotDTO convert(AccommodationDTO accommodationDTO);
}
