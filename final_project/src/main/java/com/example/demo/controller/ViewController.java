package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

// thymeleaf 뷰 출력을 담당하는 컨트롤러 분리
@Controller
@ApiIgnore
public class ViewController {
	@GetMapping({"/","/board/list"})
	public String list() {
		return "/board/list";
	}
	
	@GetMapping("/board/read")
	public void read() {
	}
	
	@GetMapping("/board/write")
	public void write() {
	}
}
