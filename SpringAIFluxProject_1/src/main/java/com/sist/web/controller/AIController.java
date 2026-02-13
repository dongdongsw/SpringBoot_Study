package com.sist.web.controller;


import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class AIController {
	
	@GetMapping("/main")
	public String main_page(Model model) {
		

		return "main";
	}
	
	@GetMapping("/sync")
	public String sync_page(Model model) {
		
		
		model.addAttribute("msg", "Hello ThymeLeaf + 일반 전송");
		return "sync";
	}
	
	@GetMapping("/stream")
	public Mono<String> stream_page(Model model) {
		
		
		model.addAttribute("msg", "Hello ThymeLeaf + WebFlux 전송");
		return Mono.just("stream");
	}
	
	@GetMapping( value = "/stream2")
	public Flux<String> stream2_page(Model model) {
		
		
		model.addAttribute("msg", "Hello ThymeLeaf + WebFlux 전송");
		return Flux.just(
				"Java : 웹 프로그램의 기본",
				"Oracle : CRUD 정리",
				"JSP / ThymeLeaf : 자바기반의 웹 프론트",
				"spring/spring-boot : 라이브러리",
				"SpringAI : JPA 형식"
				).delayElements(Duration.ofSeconds(3));
	}
}
