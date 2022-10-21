package org.ga2.buna.service.spot;

import org.ga2.buna.dto.spot.traffic.TrafficDTO;

import java.util.List;

public interface TrafficToSpot {
    List<Spot> convertAll();
}
