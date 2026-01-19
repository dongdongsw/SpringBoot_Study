package com.sist.web.security;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import lombok.RequiredArgsConstructor;

import java.security.*; // Principal
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class WebSocketListener {

	private final WebSocketSessionRegistry wsRegistry;
	private final SimpMessagingTemplate template;
	private final UserSessionRegistry userRegistry;
	
	// Stomp => javascript : Stomp (storm) , SockJS
	// 유저가 접속
	@EventListener
	public void connect(SessionConnectEvent event) {
		StompHeaderAccessor acc = StompHeaderAccessor.wrap(event.getMessage());
		
		Principal p = acc.getUser();
		if(p == null) {
			return;
		}
		String userid = p.getName();
		String sessionId = acc.getSessionId();
		
		wsRegistry.register(userid, sessionId);
		userRegistry.add(userid);
		// 접속시 저장
		// 접속자 목록 갱신
		template.convertAndSend("/topic/users", userRegistry.getUsers());
	}
	
	@EventListener
	public void subscribe(SessionSubscribeEvent event) {
		StompHeaderAccessor acc = StompHeaderAccessor.wrap(event.getMessage());
		
		String dest = acc.getDestination();
		
		if("/topic/users".equals(dest)) {
			template.convertAndSend("/topic/users",new ArrayList<>(userRegistry.getUsers()));
		}
	}
	
	// 유저가 해제
	@EventListener
	public void disconnect(SessionDisconnectEvent event) {
		
		StompHeaderAccessor acc = StompHeaderAccessor.wrap(event.getMessage());
		
		Principal p = acc.getUser();
		if(p == null) {
			return;
		}
		String userid = p.getName();
		String sessionId = acc.getSessionId();
		wsRegistry.unregister(userid, sessionId);
		userRegistry.remove(userid);
		
		// 접속자 목록 갱신
		template.convertAndSend("/topic/users", userRegistry.getUsers());
	}
	
}
