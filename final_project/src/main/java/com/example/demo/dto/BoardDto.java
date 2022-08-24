package com.example.demo.dto;

import java.time.*;
import java.util.*;

import javax.validation.constraints.*;

import com.example.demo.entity.*;

import lombok.*;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class BoardDto {
	@Data
	public static class ForList {
		private Integer bno;
		private String title;
		private String writer;
		private LocalDateTime writeTime;
		private Integer readCnt;
		private Integer commentCnt;
	}
	
	@Data
	public static class Page {
		private Integer pageno;
		private Integer pagesize;
		private Integer totalcount;
		private Collection<ForList> boardList;
	}
	
	// Read는 board, comment 두 테이블을 출력
	// 1. left outer join으로 처리
	// 2. board 읽고, comment 읽고.
	@Data
	public static class Read {
		private Integer bno;
		private String title;
		private String content;
		private String writer;
		private LocalDateTime writeTime;
		private Integer readCnt;
		private Integer goodCnt;
		private Integer badCnt;
		private Integer commentCnt;
		private List<CommentDto.Read> comments;
	}
	
	@Data
	public static class Write {
		@NotEmpty(message="제목은 필수입력입니다")
		private String title;
		@NotEmpty(message="내용은 필수입력입니다")
		private String content;
		public Board toEntity() {
			return Board.builder().title(title).content(content).build();
		}
	}
	
	@Data
	public static class Update {
		@NotNull(message="글번호는 필수입력입니다")
		private Integer bno;
		@NotEmpty(message="제목은 필수입력입니다")
		private String title;
		@NotEmpty(message="내용은 필수입력입니다")
		private String content;
		public Board toEntity() {
			return Board.builder().title(title).content(content)
					.bno(bno).build();
		}
	}
}








