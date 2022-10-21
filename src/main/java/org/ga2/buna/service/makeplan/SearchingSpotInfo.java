package org.ga2.buna.service.makeplan;

import org.ga2.buna.dto.plandetail.SearchInfoDTO;

import java.util.List;

public interface SearchingSpotInfo {

    List<SearchInfoDTO> getInfo(int planRownum);

    SearchInfoDTO getInfo(String spotName, String serialNumber);
}
