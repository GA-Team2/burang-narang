package org.ga2.buna.service.spot.accommodation;


import org.ga2.buna.dto.spot.SpotDTO;

import java.util.List;

public interface Accommodation {
    List<SpotDTO> findAll();
    SpotDTO findBySerialNumber(String serialNumber);
}
