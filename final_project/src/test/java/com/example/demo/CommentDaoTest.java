package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CommentDao;
import com.example.demo.entity.Comment;

@SpringBootTest
public class CommentDaoTest {
	@Autowired
	private CommentDao dao;
	// Test 1. save
//	@Test
	public void saveTest() {
		assertEquals(1, dao.save(Comment.builder().cno(1).content("ss").writer("winter").bno(4).build()));
	}
	// Test 2. findByBno
//	@Test
	public void findByBnoTest() {
		assertEquals(true, dao.findWriterById(1500).isEmpty());
		
	}
	// Test 3. findWriterByBno
	@Test
	public void findWriterByBnoTest(){
		assertEquals(true, dao.findWriterById(1500).isEmpty());
		assertEquals(true, dao.findWriterById(1).isPresent());
	}
	// Test 4. deleteByCno
	@Transactional
	@Test
	public void deleteByCnoTestTest(){
		assertEquals(1, dao.deleteByCno(27));
		assertEquals(0, dao.deleteByCno(1500));
	}
	// Test 5. deleteByBno 
	@Transactional
	@Test
	public void deleteByBnoTest() {
		assertNotEquals(0, dao.deleteByBno(1));
	}
}
















