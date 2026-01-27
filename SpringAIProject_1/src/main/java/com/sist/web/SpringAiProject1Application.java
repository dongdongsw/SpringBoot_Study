package com.sist.web;

import java.util.Scanner;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiProject1Application {

   
	public static void main(String[] args) {
		SpringApplication.run(SpringAiProject1Application.class, args);
	}

	@Bean
	public CommandLineRunner runner1(GoogleGenAiChatModel model) {
//		System.out.println("ChatModel 생성 :" + model);
		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("무엇이든 물어보살");
//		String cmd = scan.next();
		
		return args ->{
			String response = model.call("서울 지역 여행 추천지역만 출력");
			System.out.println("[결과]" + response);
		};
		
	}
	
	/*
	@Bean
	public CommandLineRunner runner2(GoogleGenAiChatModel model) {
		
		System.out.println("ChatModel 생성 : " + model);
		return args -> {
			ChatResponse response = model.call(
					new Prompt("부산지역 여행 추천",
							ChatOptions.builder().model(null).build()
					)
			);
		};
	}
	*/
}
