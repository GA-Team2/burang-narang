package org.ga2.buna.service.spot.traffic;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.traffic.TrafficRepository;
import org.ga2.buna.dto.spot.traffic.TrafficDTO;
import org.ga2.buna.service.spot.Spot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrafficList implements Traffic {

    private final TrafficRepository trafficRepository;
    private final TfToSpot tfToSpot;

    @Override
    public List<Spot> findAll() {
        List<Spot> spotList = new ArrayList<>();

        for (TrafficDTO trafficDTO: trafficRepository.selectAll()) {
            spotList.add(tfToSpot.convert(trafficDTO));
        }

        return spotList;
    }

    @Override
    public Spot findBySerialNumber(String serialNumber) {
        return tfToSpot.convert(trafficRepository.selectBySerialNumber(serialNumber));
    }
}
