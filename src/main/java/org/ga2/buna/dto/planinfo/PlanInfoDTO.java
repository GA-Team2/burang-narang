package org.ga2.buna.dto.planinfo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class PlanInfoDTO {
    private int planRowNumber;
    private String memberNickName;
    private String planTitle;
    private Timestamp planFirstDate;
    private Timestamp planLastDate;
    private String tagNameList; // nullable
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")//왜안뜨니
    private Timestamp planRegisterDate; // 글 작성 시간
    private int planLike;
    private int planPublic; // 공개 유무
}
