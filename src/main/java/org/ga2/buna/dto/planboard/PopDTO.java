package org.ga2.buna.dto.planboard;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class PopDTO {

    //PLANINFO TABLE
    private int planRownum;
    private String planTitle;
    private String tagNamelist;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private Timestamp planRegdate;
    private int planLike;

    //TAGLIST TABLE
//    private String tagName;
}