package org.ga2.buna.dto.spot;

import lombok.Getter;
import lombok.Setter;

/**
 * 장소 정보 이름 통일하는 클래스
 *
 * @author 한애채
 */
@Getter
@Setter
public class SpotDTO {
    private String spotSerialNumber;
    private String spotType;
    private String spotName;
    private String spotPhoneNumber;
    private String spotLocation;
    private String spotStartTime;
    private String spotEndTime;
    private String spotPhoto;
}
