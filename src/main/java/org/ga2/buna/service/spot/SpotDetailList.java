package org.ga2.buna.service.spot;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.spotdetail.SpotDetailRepository;
import org.ga2.buna.dto.spot.spotdetail.SpotDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotDetailList implements SpotDetail {
    private final SpotDetailRepository spotDetailRepository;

    @Override
    public List<SpotDetailDTO> findBySpotName(String spotName) {
        return spotDetailRepository.selectBySpotNameLike(spotName);
    }
}
