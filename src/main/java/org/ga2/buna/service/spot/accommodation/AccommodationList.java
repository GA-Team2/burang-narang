package org.ga2.buna.service.spot.accommodation;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.accommodation.AccommodationRepository;
import org.ga2.buna.dto.spot.accommodation.AccommodationDTO;
import org.ga2.buna.dto.spot.SpotDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 숙소 데이터 리스트 반환하는 클래스
 *
 * @author 한애채
 */
@Service
@RequiredArgsConstructor
public class AccommodationList implements Accommodation {

    private final AccommodationRepository accommodationRepository;
    private final AcToSpot acToSpot;

    /**
     * 숙소 데이터 리스트 반환
     *
     * @return 장소 데이터 리스트
     */
    @Override
    public List<SpotDTO> findAll() {
        List<SpotDTO> spotList = new ArrayList<>();

        for (AccommodationDTO accommodationDTO : accommodationRepository.selectAll()) {
            spotList.add(acToSpot.convert(accommodationDTO));
        }

        return spotList;
    }

    /**
     * 장소 고유 번호를 가지는 숙소 데이터 반환
     *
     * @param serialNumber 장소 고유 번호
     * @return 장소 데이터
     */
    @Override
    public SpotDTO findBySerialNumber(String serialNumber) {
        return acToSpot.convert(accommodationRepository.selectBySerialNumber(serialNumber));
    }
}
