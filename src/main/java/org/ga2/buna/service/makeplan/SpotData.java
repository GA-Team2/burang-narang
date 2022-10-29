package org.ga2.buna.service.makeplan;


import org.ga2.buna.dto.spot.SpotDTO;

import java.util.List;

public interface SpotData {
    List<SpotDTO> findAll(String spot);
    List<SpotDTO> findBySpotName(String spotName);
}
