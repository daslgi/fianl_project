package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.transaction.annotation.*;

import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.service.*;

@SpringBootTest
public class BoardServiceTest {
	@Autowired
	private BoardService service;
	
	//@Test
	public void writeTest() {
		BoardDto.Write dto = BoardDto.Write.builder().title("xxxxx").content("yyyyyy").build();
		Board board = service.write(dto, "spring");
		assertEquals("spring", board.getWriter());
	}
	
	// 테스트 실패
	@Transactional
	@Test
	public void readTest() {
		BoardDto.Read dto = service.read(41, "spring");
		assertEquals("spring", dto.getWriter());
		assertEquals(1, dto.getReadCnt());
	}
}
