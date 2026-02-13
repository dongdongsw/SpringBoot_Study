package com.sist.web.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sist.web.service.ChatService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
public class ChatBotController {
	private final ChatService cService;
	
    @GetMapping("/sync")
    public String sync_chat()
    {
    	return "sync";
    }
    @GetMapping(value="/chat/sync")
    @ResponseBody
    public String sycnChat(@RequestParam("message") String message)
    {
    	return cService.syncChat(message);
    }
    
    @GetMapping("/stream")
    public String stream_chat()
    {
    	return "stream";
    }
    
    @GetMapping(value="/chat/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<String> streamChat(@RequestParam("message") String message)
    {
    	return cService.streamChat(message);
    }
}