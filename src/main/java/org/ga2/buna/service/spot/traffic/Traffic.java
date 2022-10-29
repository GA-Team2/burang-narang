package org.ga2.buna.service.spot.traffic;


import org.ga2.buna.dto.spot.SpotDTO;

import java.util.List;

public interface Traffic {
    List<SpotDTO> findAll();
    SpotDTO findBySerialNumber(String serialNumber);
}
