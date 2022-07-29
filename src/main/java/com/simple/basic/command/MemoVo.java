package com.simple.basic.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemoVo {
	private int mno;
	@NotBlank
	private String memo;
	@Pattern(message = "010-0000-0000 형식입니다.", regexp= "010-[0-9]{3,4}-[0-9]{4}")
	private String phone;
	@Pattern(message = "비밀번호는 숫자 4자리 입력하세요." ,regexp = "[0-9]*")
	private String pw;
	private char secret;
}
