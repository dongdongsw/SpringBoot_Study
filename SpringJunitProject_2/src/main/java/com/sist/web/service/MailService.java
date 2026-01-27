package com.sist.web.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService {

	private final JavaMailSender mailSender;
	
	
	public void sendTextMail(String to, String subject, String content, String from) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		message.setFrom(from);
		mailSender.send(message);
	}
	
	
	
	public void sendHtmlMail(String to, String subject, String html, String from) throws MessagingException{
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(html,true);
		helper.setFrom(from);
		
		mailSender.send(message);
		
	}
	
}
