package com.example.demo.controller;

import java.security.*;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.*;
import org.springframework.validation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.*;
import com.example.demo.dto.BoardDto.*;
import com.example.demo.entity.*;
import com.example.demo.service.*;

@Validated
@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/board/write")
	public void write() {
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/board/new")
	public ResponseEntity<String> write(@Valid BoardDto.Write dto, BindingResult bindingResult, Principal principal) {
		Board board = service.write(dto, "spring");
		return ResponseEntity.ok("/board/read?bno=" + board.getBno());
	}
	
	@GetMapping("/board/read")
	public void read() {
	}
	
//	@GetMapping("/board")
//	public ResponseEntity<BoardDto.Read> read(Integer bno, Principal principal) {
//		String loginId = principal==null? null : principal.getName();
//		BoardDto.Read dto = service.read(bno, loginId);
//		return ResponseEntity.ok(dto);
//	}
//	
//	@PreAuthorize("isAuthenticated()")
//	@DeleteMapping("/board")
//	public ResponseEntity<String> delete(Integer bno, Principal principal) {
//		Boolean result = service.delete(bno, principal.getName());
//		if(result==false)
//			return ResponseEntity.status(HttpStatus.CONFLICT).body("작업 실패");
//		return ResponseEntity.ok("/board/list");
//	}
//	
//	
//	@PreAuthorize("isAuthenticated()")
//	@PutMapping("/board")
//	public ResponseEntity<String> update(@Valid BoardDto.Update dto,
//			BindingResult bindingResult, Principal principal) {
//		Boolean result = service.update(dto, principal.getName());
//		if(result==false)
//			return ResponseEntity.status(HttpStatus.CONFLICT).body("작업 실패");
//		return ResponseEntity.ok("/board/read?bno="+dto.getBno());
//	}
//	
//	@GetMapping("/board/list")
//	public void list() {
//	}
//	
//	@GetMapping("/board/all")
//	public ResponseEntity<Page> list(@RequestParam(defaultValue="1")
//		Integer pageno) {
//		return ResponseEntity.ok(service.list(pageno));
//	}
//	
}











