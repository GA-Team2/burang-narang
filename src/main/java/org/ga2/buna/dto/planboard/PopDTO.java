package org.ga2.buna.dto.planboard;

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
    private Timestamp planRegdate;
    private int planLike;

    //TAGLIST TABLE
    private String tagName;
}