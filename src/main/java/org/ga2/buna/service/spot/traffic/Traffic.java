package org.ga2.buna.service.spot.traffic;

import org.ga2.buna.service.spot.Spot;

import java.util.List;

public interface Traffic {
    List<Spot> findAll();
    Spot findBySerialNumber(String serialNumber);
}
