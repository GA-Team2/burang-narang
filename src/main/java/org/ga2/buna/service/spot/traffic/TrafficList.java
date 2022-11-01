package org.ga2.buna.service.spot.traffic;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.traffic.TrafficRepository;
import org.ga2.buna.dto.spot.traffic.TrafficDTO;
import org.ga2.buna.dto.spot.SpotDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 교통 데이터 리스트 반환하는 클래스
 *
 * @author 한애채
 */
@Service
@RequiredArgsConstructor
public class TrafficList implements Traffic {

    private final TrafficRepository trafficRepository;
    private final TfToSpot tfToSpot;

    /**
     * 교통 데이터 리스트 반환
     *
     * @return 장소 데이터 리스트
     */
    @Override
    public List<SpotDTO> findAll() {
        List<SpotDTO> spotList = new ArrayList<>();

        for (TrafficDTO trafficDTO : trafficRepository.selectAll()) {
            spotList.add(tfToSpot.convert(trafficDTO));
        }

        return spotList;
    }

    /**
     * 장소 고유 번호를 가지는 교통 데이터 반환
     *
     * @param serialNumber 장소 고유 번호
     * @return 장소 데이터
     */
    @Override
    public SpotDTO findBySerialNumber(String serialNumber) {
        return tfToSpot.convert(trafficRepository.selectBySerialNumber(serialNumber));
    }
}
