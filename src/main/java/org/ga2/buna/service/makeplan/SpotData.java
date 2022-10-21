package org.ga2.buna.service.makeplan;

import org.ga2.buna.service.spot.Spot;

import java.util.List;

public interface SpotData {
    List<Spot> findAll(String spot);
    List<Spot> findBySpotName(String spotName);
}
