package com.example.demo.dto;

import java.time.*;

import com.fasterxml.jackson.annotation.*;

import lombok.*;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class CommentDto {
	@Data
	public static class Read {
		private Integer cno;
		private String content;
		private String writer;
		private LocalDateTime writeTime;
	}
}







