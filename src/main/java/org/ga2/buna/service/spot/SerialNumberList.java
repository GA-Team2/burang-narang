package org.ga2.buna.service.spot;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.spotdetail.SpotDetailDAO;
import org.ga2.buna.dto.spot.spotdetail.SpotDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SerialNumberList implements SerialNumber {
    private final SpotDetailDAO spotDetailDAO;

    @Override
    public List<SpotDetailDTO> findBySpotName(String spotName) {
        return spotDetailDAO.selectBySpotName(spotName);
    }
}
