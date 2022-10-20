package org.ga2.buna.service.spot.restaurant;

import org.ga2.buna.service.spot.Spot;

import java.util.List;

public interface Restaurant {
    List<Spot> findAll();
    Spot findBySerialNumber(String serialNumber);
}
