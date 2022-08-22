package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.demo.dao.*;
import com.example.demo.dto.*;
import com.example.demo.dto.BoardDto.*;
import com.example.demo.entity.*;
import com.example.demo.exception.*;

@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;
	@Value("${mproject.pagesize}")
	private Integer pagesize;
	
	public Board write(BoardDto.Write dto, String loginId) {
		Board board = dto.toEntity().addWriter(loginId);
		boardDao.save(board);
		return board;
	}

	public Read read(Integer bno, String loginId) {
		return boardDao.findById(bno).orElseThrow(()->new BoardNotFoundException());
	}
	
	public void delete(Integer bno, String loginId) {
		String result = boardDao.findWriterById(bno).orElseThrow(()->new BoardNotFoundException());
		if(result.equals(loginId)==false)
			throw new JobFailException("삭제할 권한이 없습니다.");
		boardDao.deleteById(bno);
	}

	public void update(BoardDto.Update dto, String loginId) {
		String result = boardDao.findWriterById(dto.getBno()).orElseThrow(()->new BoardNotFoundException());
		if(result.equals(loginId)==false)
			throw new JobFailException("변경할 권한이 없습니다.");
		boardDao.update(dto.toEntity());
	}
	
	public Page list(Integer pageno) {
		Integer totalcount = boardDao.count(null);
		// pageno		start	end
		// 1			1		10
		// 2			11		20
		// end가 totalcount보다 크다면.... totalcount가 end
		
		Integer start = (pageno-1)*pagesize+1;
		Integer end = start + pagesize - 1;
		if(end>totalcount)
			end=totalcount;
		
		Page page = new Page();
		page.setPageno(pageno);
		page.setPagesize(pagesize);
		page.setTotalcount(totalcount);
		page.setBoardList(boardDao.findAll(null, start, end));
		return page;
	}
}
