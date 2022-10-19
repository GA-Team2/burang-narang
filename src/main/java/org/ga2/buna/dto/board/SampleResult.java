package org.ga2.buna.dto.board;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 최종 결과를 화면으로 보내기 위한 DTO, Sample과 Pagination을 갖고 있음
 */
@Getter
@Setter
public class SampleResult {
    public List<PopDTO> popList;
    public  Pagination pagination;
}
