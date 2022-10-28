package org.ga2.buna.dto.index;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DDayDTO {
	//남은 일 수 필드
	private int DDay;
	//null포인터 에러 방지 필드
	private String empty;
}