package com.example.demo.exception;

// Exception : 체크하는 예외의 조상(try ~ catch 필요)
// RuntimeException : 체크하지 않는 예외의 조상 ... 가벼운 예외
public class BoardNotFoundException extends RuntimeException {

}
