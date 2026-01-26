package com.sist.test;

import java.util.Scanner;


/*
 * 나열형 : 상수의 집합 => 필요한 데이터를 포함해서 사용이 가능하다
 * SEOUL("60", "127", "서울")
 * 
 * public enum CityGrid{
 * 	SEOUL, BUSAN ...
 * }
 * 
 */
public class MainClass {
	public static void main(String[] args) {
//		CityGrid city = CityGrid.SEOUL;
//		System.out.println(city);
//		System.out.println(city.getKrName());
//		System.out.println(city.getNx());
//		System.out.println(city.getNy());
		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("지역 입력 : ");
//		String name = scan.next();
//		
//		CityGrid c = CityGrid.from(name);
//		System.out.println(c.getKrName());
//		System.out.println(c.getNx());
//		System.out.println(c.getNy());
		
		Scanner scan = new Scanner(System.in);
		System.out.println("지역 입력 : ");
		String name = scan.next();
		
		for(CityGrid c : CityGrid.values()) {
			
			if(c.getKrName().equals(name)) {
				switch (c) {
					
					case SEOUL -> 
					{
						System.out.println("서울 날씨");
						break;
					}
					
					case BUSAN -> 
					{
						System.out.println("부산 날씨");
						break;
					}
					case JEJU -> 
					{
						System.out.println("제주 날씨");
						break;
					}
				}
			}
		}
	}
}
