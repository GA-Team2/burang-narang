package org.ga2.buna.service.spot.event;

import org.ga2.buna.service.spot.Spot;

import java.util.List;

public interface Event {
    List<Spot> findAll();
    Spot findBySerialNumber(String serialNumber);
}
