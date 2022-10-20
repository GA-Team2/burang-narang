package org.ga2.buna.service.spot;

import lombok.RequiredArgsConstructor;
import org.ga2.buna.dto.spot.spotdetail.SpotDetailDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SerialNumberToSpot {
    private final SerialNumberList serialNumberList;

    public List<Spot> findBySerialNumber(String spotName) {
        List<Spot> spotList = new ArrayList<>();

        for (SpotDetailDTO spotDetailDTO: serialNumberList.findBySpotName(spotName)) {
            char spotCode = spotDetailDTO.getSpotSerialNumber().charAt(0);

            switch (spotCode) {
                case 'T': break;
                case 'A': break;
                case 'R': break;
                case 'E': break;
            }
        }
        return spotList;
    }
}
