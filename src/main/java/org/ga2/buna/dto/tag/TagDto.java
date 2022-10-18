package org.ga2.buna.dto.tag;

import lombok.Getter;
import lombok.Setter;

/**
 * 추천 태그 DTO
 * @author 김규빈
 */
@Getter @Setter
public class TagDto {
	private String tagName;
	private int tagHit;
}
