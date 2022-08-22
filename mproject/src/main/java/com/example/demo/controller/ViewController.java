package com.example.demo.controller;

import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.annotations.*;

// thymeleaf 뷰 출력을 담당하는 컨트롤러 분리
@Controller
@ApiIgnore
public class ViewController {
	@GetMapping("/board/list")
	public void list() {
	}
	
	@GetMapping("/board/read")
	public void read() {
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/board/write")
	public void write() {
	}
}
