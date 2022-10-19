package org.ga2.buna.dto.board;

import lombok.Getter;
import lombok.Setter;

/**
 * 리스트 조회 쿼리를 실행시 페이지에 해당하는 리스트를 끊어서 가져올 parameter를 넘기기 위한 DTO
 */
@Getter
@Setter
public class SampleParam {
    public int displayRow;
    public int offset;
}
