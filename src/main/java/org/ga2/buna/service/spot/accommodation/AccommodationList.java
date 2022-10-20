package org.ga2.buna.service.spot.accommodation;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dao.spot.accommodation.AccommodationDAO;
import org.ga2.buna.dto.spot.accommodation.AccommodationDTO;
import org.ga2.buna.service.spot.Spot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
* 숙소 데이터 리스트 반환하는 클래스
* 
* @author 한애채
* */
@Service
@RequiredArgsConstructor
public class AccommodationList implements Accommodation {

    private final AccommodationDAO accommodationDAO;
    private final AcToSpotList acToSpotList;

    /*
    * 숙소 데이터 리스트 반환
    * 
    * @return 장소 데이터 리스트
    * */
    @Override
    public List<Spot> findAll() {
        List<Spot> spotList = new ArrayList<>();

        for (AccommodationDTO accommodationDTO: accommodationDAO.selectAll()) {
            spotList.add(acToSpotList.convert(accommodationDTO));
        }

        return spotList;
    }
    
    /*
    * 장소 고유 번호를 가지는 숙소 데이터 반환
    *
    * @param serialNumber 장소 고유 번호
    * @return 장소 데이터
    * */
    @Override
    public Spot findBySerialNumber(String serialNumber) {
        return acToSpotList.convert(accommodationDAO.selectBySerialNumber(serialNumber));
    }
}
