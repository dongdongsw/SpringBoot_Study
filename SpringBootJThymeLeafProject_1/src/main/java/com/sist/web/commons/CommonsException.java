package com.sist.web.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonsException {

	@ExceptionHandler(Exception.class)
	public void exception(Exception ex) {
		System.out.println("======================== 에러발생 =============================");
		ex.printStackTrace();
		System.out.println("=============================================================");
	}
	
	@ExceptionHandler(Throwable.class)
	public void throwsable(Throwable ex) {
		System.out.println("======================== 에러발생 =============================");
		ex.printStackTrace();
		System.out.println("=============================================================");
	}
	
	
}
