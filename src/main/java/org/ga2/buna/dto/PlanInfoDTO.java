package org.ga2.buna.dto;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanInfoDTO {
	private int planRowNum;
	private String memberNickName;
	private String planTitle;
	private Timestamp planFirstDate;
	private Timestamp planLastDate;
	private String tagNameList; // nullable
	private Timestamp planRegDate; // 글 작성 시간
	private int planLike;
	private int planPublic; // 공개 유무
}
