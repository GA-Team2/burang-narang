package org.ga2.buna.service.spot.accommodation;

import org.ga2.buna.service.spot.Spot;

import java.util.List;

public interface Accommodation {
    List<Spot> findAll();
    Spot findBySerialNumber(String serialNumber);
}
