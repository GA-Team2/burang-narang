package org.ga2.buna.service.spot.traffic;

import org.ga2.buna.dto.spot.traffic.TrafficDTO;
import org.ga2.buna.service.spot.Spot;

public interface TfToSpot {
    Spot convert(TrafficDTO trafficDTO);
}
