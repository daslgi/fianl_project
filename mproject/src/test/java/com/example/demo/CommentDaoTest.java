package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.transaction.annotation.*;

import com.example.demo.dao.*;
import com.example.demo.entity.*;

@SpringBootTest
public class CommentDaoTest {
	@Autowired
	private CommentDao dao;
	
	//@Test
	public void saveTest() {
		dao.save(Comment.builder().bno(1).content("zzz")
			.writer("winter").build());
	}
	
	//@Test
	public void findByBnoTest() {
		dao.findByBno(2);
	}
	
	//@Test
	public void findWriterTEst() {
		assertEquals("winter", dao.findWriterById(2).get());
	}
	
	@Transactional
	//@Test
	public void deleteByCnoTest() {
		assertEquals(1, dao.deleteByCno(2));
	}
	
	@Transactional
	@Test
	public void deleteByBnoTest() {
		assertNotEquals(0, dao.deleteByBno(1));
	}
}
















