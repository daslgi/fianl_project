package com.example.demo.service;

import java.util.*;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.demo.dao.*;
import com.example.demo.dto.*;
import com.example.demo.dto.BoardDto.*;
import com.example.demo.entity.*;

@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;
	@Value("10")
	private Integer pagesize;
	
	public Board write(@Valid BoardDto.Write dto, String loginId) {
		Board board = dto.toEntity().addWriter(loginId);
		boardDao.save(board);
		return board;
	}

//	public Read read(Integer bno, String loginId) {
//		BoardDto.Read dto = boardDao.findById(bno).get();
//		return dto;
//	}
//	
//	// join을 이용해서 board, List<comment>을 읽는다
//	public Read read2(Integer bno, String loginId) {
//		BoardDto.Read dto = boardDao.findById2(bno).get();
//		return dto;
//	}
//	
//	public boolean delete(Integer bno, String loginId) {
//		// 글이 없거나 글쓴이가 아니라면 false, 글을 삭제하면 true
//		Optional<String> result = boardDao.findWriterById(bno);
//		if(result.isEmpty())
//			return false;
//		if(result.get().equals(loginId)==false)
//			return false;
//		boardDao.deleteById(bno);
//		return true;
//	}
//
//	public Boolean update(BoardDto.Update dto, String loginId) {
//		Optional<String> result = boardDao.findWriterById(dto.getBno());
//		if(result.isEmpty())
//			return false;
//		if(result.get().equals(loginId)==false)
//			return false;
//		boardDao.update(dto.toEntity());
//		return true;
//	}
//	
//	public Page list(Integer pageno) {
//		Integer totalcount = boardDao.count(null);
//		// pageno		start	end
//		// 1			1		10
//		// 2			11		20
//		// end가 totalcount보다 크다면.... totalcount가 end
//		
//		Integer start = (pageno-1)*pagesize+1;
//		Integer end = start + pagesize - 1;
//		if(end>totalcount)
//			end=totalcount;
//		
//		Page page = new Page();
//		page.setPageno(pageno);
//		page.setPagesize(pagesize);
//		page.setTotalcount(totalcount);
//		page.setBoardList(boardDao.findAll(null, start, end));
//		return page;
//	}
}









