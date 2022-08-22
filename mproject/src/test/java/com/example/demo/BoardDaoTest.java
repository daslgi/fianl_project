package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.transaction.annotation.*;

import com.example.demo.dao.*;
import com.example.demo.entity.*;

@SpringBootTest
public class BoardDaoTest {
	@Autowired
	BoardDao boardDao;
	
	//@Test
	public void diTest() {
		assertNotNull(boardDao);
	}
	
	//@Test
	public void countTest() {
		assertEquals(0, boardDao.count(null));
		assertEquals(0, boardDao.count("spring"));
	}
	
	//@Test
	public void findAllTest() {
		boardDao.findAll(null, 1, 10);
		boardDao.findAll("spring", 11, 20);
	}
	
	//@Test
	public void saveTest() {
		Board board = Board.builder().title("aaaa").content("bbb").writer("spring").build();
		assertEquals(1, boardDao.save(board));
	}
	
	//@Test
	public void updateTest() {
		boardDao.update(Board.builder().bno(1).readCnt(1).build());
		boardDao.update(Board.builder().bno(1).goodCnt(1).build());
		boardDao.update(Board.builder().bno(1).commentCnt(15).build());
		boardDao.update(Board.builder().bno(1).title("변경").content("변경").build());
	}
	
	//@Test
	public void findByIdTest() {
		System.out.println(boardDao.findById(1));
	}
	
	//@Test
	public void findWriterTest() {
		System.out.println(boardDao.findWriterById(1));
	}
	
	@Transactional
	@Test
	public void deleteByIdTest() {
		assertEquals(1, boardDao.deleteById(1));
	}
}
