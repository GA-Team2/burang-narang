package org.ga2.buna.service.spot.traffic;

import org.ga2.buna.dto.spot.SpotDTO;
import org.ga2.buna.dto.spot.traffic.TrafficDTO;

public interface TfToSpot {
    SpotDTO convert(TrafficDTO trafficDTO);
}
