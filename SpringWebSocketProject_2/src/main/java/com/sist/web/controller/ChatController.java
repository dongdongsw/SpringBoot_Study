package com.sist.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.vo.ChatMessage;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatController {

	private final SimpMessagingTemplate messageingTemplate;
	
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	// public => 전체 / private => 귓속말
	public ChatMessage sendMessage(ChatMessage message) {
		
		
		
		return message;
	}
	
	@MessageMapping("/chat.private")
	public void privateMessage(ChatMessage message) {
		System.out.println("my:" + message.getSender());
		System.out.println("you:" + message.getReceiver());
		System.out.println("message:" + message.getMessage());
		messageingTemplate.convertAndSend(
			
				"/queue/private/" + message.getReceiver(),	
				message
		);
	}
	
	/*
	 * 클라이언트 전송 => /app/chat.send
	 * 서버 처리
	 * 서버 => /topic/public
	 * 
	 */
	
	@GetMapping("/chat")
	public String chat_page() {
		
		return "chat";
	}
}
