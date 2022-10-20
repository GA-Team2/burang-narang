package org.ga2.buna.service.makeplan;

import org.ga2.buna.dto.plandetail.SearchInfoDTO;

public interface SearchingMapInfo {

    SearchInfoDTO searchInfo(String spotname, String serialnumber);
}
