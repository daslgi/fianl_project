package com.example.demo.controller.advice;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


// 내가정한 예외409가 나오도록 다른 에러들을 바꿔주는 곳
@RestControllerAdvice
public class BoardControllerAdvice {
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> ConstraintViolationException(){
		return ResponseEntity.status(HttpStatus.CONFLICT).body("데이터가 누락되었습니다");
	}
}
