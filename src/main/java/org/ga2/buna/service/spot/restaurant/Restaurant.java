package org.ga2.buna.service.spot.restaurant;


import org.ga2.buna.dto.spot.SpotDTO;

import java.util.List;

public interface Restaurant {
    List<SpotDTO> findAll();
    SpotDTO findBySerialNumber(String serialNumber);
}
