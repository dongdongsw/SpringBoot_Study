package com.sist.main;

import java.util.ArrayList;
import java.util.List;

public class MainClass3 {

	public static void main(String[] args) {

//		List<String> names = new ArrayList<String>();
//		names.add("심청이");
//		names.add("박문수");
//		names.add("이순신");
//		names.add("강감찬");
//		names.add("김두한");
//		
//		//출력
//		for(String name : names) {
//			System.out.println(name);
//		}
//		
//		
//		System.out.println("===================");
//		names.forEach(name->System.out.println(name));
//		
		List<String> colors = List.of("red","blue","black","green","yellow");
		colors.stream()
			.filter(c->c.startsWith("b")) // 조건 검색
			.map(String::toUpperCase) // 옵션
			//.forEach(System.out::println);
			.forEach(c->System.out.println(c));
			// 	검색 / 정렬 / 출력 / null 체크
		
		/*
		 * 한줄 처리 => if ~ else => 삼항 연산자
		 * 조건 : filter
		 * 변환 : map
		 * 출력 : forEach
		 * ------------------------------------
		 * 복잡한 비즈니스 로직(x)
		 * 디버깅이 많은 경우(x)
		 * 
		 */
	}

}
