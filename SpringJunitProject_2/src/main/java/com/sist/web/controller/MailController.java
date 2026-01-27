package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.web.service.MailService;
import com.sist.web.vo.MailVO;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MailController {

	private final MailService mSender;
	
	@GetMapping("/mail")
	public String mail_page() {
		
		return "send";
	}
	
	@PostMapping("/send_ok")
	public String mail_ok(
			@ModelAttribute MailVO vo
			) throws MessagingException{
		
		//mSender.sendTextMail(vo.getReciver(), vo.getSubject(), vo.getContent(), vo.getSender());
		mSender.sendHtmlMail(vo.getReciver(), vo.getSubject(), vo.getContent(), vo.getSender());
		return "success";
	}
	
}
