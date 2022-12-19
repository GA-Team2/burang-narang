package org.ga2.buna.service.spot.event;

import org.ga2.buna.dto.spot.SpotDTO;

import java.util.List;

public interface Event {
    List<SpotDTO> findAll();

    SpotDTO findBySerialNumber(String serialNumber);
}
