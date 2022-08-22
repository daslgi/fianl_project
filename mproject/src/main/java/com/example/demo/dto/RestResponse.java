package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.*;
import lombok.*;

@Data
@AllArgsConstructor
public class RestResponse {
	@Schema(description="작업 메시지", example="성공|오류발생")
	private String message;
	@Schema(description="작업 결과 데이터")
	private Object result;
}
