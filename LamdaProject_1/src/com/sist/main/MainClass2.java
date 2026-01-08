package com.sist.main;

/*
 * 	함수형 인터페이스
 * 		1. 람다식은 함수형 인터페이스에만 사용이 가능
 * 			=> 조건 : 추상메소드 (선언만된 메소드 1개)
 * 		2. 인터페이스 위에 
 * 			@FunctionInterface => 람다 사용을 할 수 있는 인터페이스
 * 			 => 추상 메소드가 1개
 * 				ㄴ 구현이 안된 메소드
 * 			 => 구현된 메소드 : default / static
 * 
 */
@FunctionalInterface
interface Calc{
	
	// public abstract 생략됨
	int sum(int a, int b);
	
	// jdk 가 1.8 이상부터 가능
	// double div(int a, int b); 이렇게 하면 오류남
	// public 생략됨 => 컴파일시 자동 추가 => interface : 변수/메소드가 public
	default double div(int a, int b) { // 이렇게 하면 오류 안남
		return a/b;
	}
	
	static void msg() {
		System.out.println("Hello");
	}
}

public class MainClass2 {

	public static void main(String[] args) {
		
		// 클래스 생성, 객체 생성 => 메모리가 커짐 => 속도 느림
		// 람다는 클래스 생성 x , 객체 생성. o => 메모리가 작다 => 속도 빠름
//		Calc c = new Calc() {
//			
//			@Override
//			public int sum(int a, int b) {
//				
//				return a + b;
//			}
//		};
		Calc c = (a,b) ->a+b;
		System.out.println(c.sum(10,20));
		System.out.println(c.div(10, 3));
		Calc.msg();
		// 람다 + 컬렉션
		// stream
		
	}
	
}
