package org.ga2.buna.service.spot;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.spotdetail.SpotDetailRepository;
import org.ga2.buna.dto.spot.spotdetail.SpotDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 장소 데이터 리스트 반환하는 클래스
 *
 * @author 한애채
 */
@Service
@RequiredArgsConstructor
public class SpotDetailList implements SpotDetail {
    private final SpotDetailRepository spotDetailRepository;

    /**
     * 장소 이름을 가지는 장소 시리얼 번호 리스트 반환하는 메서드
     *
     * @author 한애채
     */
    @Override
    public List<SpotDetailDTO> findBySpotName(String spotName) {
        return spotDetailRepository.selectBySpotNameLike(spotName);
    }
}
