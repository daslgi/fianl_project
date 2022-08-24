package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.BoardDao;
import com.example.demo.entity.Board;

// Junit은 단위(unit) 테스트 도구 - 메소드의 동작물 확인
@SpringBootTest
public class BoardDaoTest {
	@Autowired
	private BoardDao boardDao;
		// Test 1. dao 생성 > null 아님
//	@Test
	public void initTest() {
		assertNotNull(boardDao);
	}
	// insert, delete, update의 실행 결과는 변경된 행의 개수
	// Test 2. sava : Baord > 결과값이 1이다
	
	// tansactional 일련의 sql을 모아서 하나의 작업으로 지정 함께 commit되거나 rollback되어야한다(일부분만 동작할 수 없다)
//	@Transactional
//	@Test
	public void saveTest() {
		Board board = Board.builder().title("xxx").content("ddd").writer("summer").build();
		assertEquals(1, boardDao.save(board));
	}
	// Test 3. count : count -> 개수를 수동으로 확인해서 assert한다
//	@Test
	public void countTest() {
		assertEquals(3, boardDao.count(null));
	}
	
	// Test 4. findAll : 글이 3개 있다. 1~3까지 3개를 읽어오자
//	@Test
	public void findAllTest() {
//		assertEquals(3, boardDao.findAll(null, 1, 10).size()); 
//		assertNotNull(boardDao.findAll(null, 11, 14)); // 값이 나오면 널이아니다
		Map<String, Object> map = new HashMap<>();
		map.put("writer", null);
		map.put("start", 1);
		map.put("end", 10);
		boardDao.findAll(map);
	}
	// Test 5. update : (내용,제목), 조회수, 좋아요, 싫어요에 대해 값을 주면 update
//	@Test 
	@Transactional
	public void updateTest() {
	assertNotEquals(0, boardDao.update(Board.builder().bno(1).readCnt(1).build()));
	assertNotEquals(0, boardDao.update(Board.builder().bno(1).goodCnt(1).build()));
	assertNotEquals(0, boardDao.update(Board.builder().bno(1).commentCnt(15).build()));
	assertNotEquals(0, boardDao.update(Board.builder().bno(1).title("변경").content("변경").build()));
	}
	// Test 6. 1번글을 읽으면 비어있다, 2번글을 읽으면 존재한다
//	@Test
	public void findByIdTest() {
		System.out.println(boardDao.findById(1));
		assertEquals(true, boardDao.findById(1).isEmpty());
		assertEquals(true,boardDao.findById(2).isPresent());
	}
	// Test 6-1. 
	@Test
	public void findByIdTest2() {
		System.out.println(boardDao.findById(1));
		boardDao.findById2(2).get().getComments().forEach(c->System.out.println(c));
	}
	// Test 7. 1번글이 없다, 2번글의 글쓴이는 있다
	//@Test
	public void findWriterTest() {
		System.out.println(boardDao.findWriterById(1));
		assertEquals(true, boardDao.findWriterById(1).isEmpty());
		assertEquals(true, boardDao.findWriterById(2).isPresent());
	}
	// Test 8. 1번글의 삭제 결과는 0, 2번글의 삭제 결과는 1
	@Transactional
//	@Test
	public void deleteByIdTest() {
		assertEquals(0, boardDao.deleteById(1));
		assertEquals(1, boardDao.deleteById(2));
	}
}
