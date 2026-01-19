package com.sist.web.security;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpSession;

// 세션 강제 종료
public class SessionUtils {

	// 모든 세션 저장 장소
	private static final Map<String , HttpSession> STORE = new ConcurrentHashMap<>(); // 비동기 => 여러명이 사용할때 충돌이 남 => 충돌 최소화 시키는 것
	
	// 멀티 쓰레드의 안정성 확보를 위한 클래스
	// => Set => hashcode를 재정의
	// 정상 수행
	public static void add(HttpSession session) {
		STORE.put(session.getId(), session);
	}
	
	public static void remove(HttpSession session) {
		STORE.remove(session);
	}
	
	// 강제 종료
	public static void invalidate(String sessionId) {
		HttpSession session = STORE.get(sessionId);
		if(session != null) {
			session.invalidate();
			STORE.remove(sessionId);
		}
	}
}
