package org.ga2.buna.service.spot;

import org.ga2.buna.dto.spot.spotdetail.SpotDetailDTO;

import java.util.List;

public interface SpotDetail {
    List<SpotDetailDTO> findBySpotName(String spotName);
}
