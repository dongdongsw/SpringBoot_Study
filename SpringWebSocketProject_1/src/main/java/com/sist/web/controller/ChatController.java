package com.sist.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.vo.ChatMessage;

@Controller
public class ChatController {

	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	// public => 전체 / private => 귓속말
	public ChatMessage sendMessage(ChatMessage message) {
		
		message.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		
		return message;
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
