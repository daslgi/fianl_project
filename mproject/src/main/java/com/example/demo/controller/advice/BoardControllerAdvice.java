package com.example.demo.controller.advice;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.*;
import com.example.demo.exception.*;

@RestControllerAdvice
public class BoardControllerAdvice {
	@ExceptionHandler(BoardNotFoundException.class)
	public ResponseEntity<RestResponse> boardNotFoundExceptionHandler() {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(new RestResponse("작업 실패", "선택하신 게시물이 존재하지 않습니다"));
	}
	
	@ExceptionHandler(JobFailException.class)
	public ResponseEntity<RestResponse> jobFailExceptionHandler(JobFailException e) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(new RestResponse("작업 실패", e.getMessage()));
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<RestResponse> numberFormatExceptionHandler(NumberFormatException e) {
		Integer position = e.getMessage().lastIndexOf(":");
		String message = e.getMessage().substring(position+1);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(new RestResponse("작업 실패", "잘못된 입력 : " + message));
	}
}
