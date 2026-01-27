package com.sist.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sist.web.service.MailService;

import jakarta.mail.MessagingException;

@SpringBootTest
class SpringJunitProject2ApplicationTests {

	@Autowired
	private MailService mService;
	
//	@Test
//	public void mailTextSend() {
//		mService.sendTextMail("fishman4535@gmail.com", "매일 보내기 연습", "메일 전송 성공");
//	}
	
	@Test
	public void mailHtmlSend() throws MessagingException {
		String html = """
				<html>
					<body>
						<h2>회원가입 완료</h2>
						<p>클릭하면 Main으로 이동합니다.</p>
						<a href="/">클릭</a>
						<img src="https://i.namu.wiki/i/PwXZ-yW5f2mdFD4352NN2W1gXqovm_58d4-KewGlap7MUoKsqhrjkd91kbmueX1-vOF-zlza0KfOpU7Vt5XnvmmE2WntAdRbLoefVdOEvMzr1GeLayzkePlhwd74vzfz6l8eGuEwnWc9Km6AgA4pGg.webp">
					</body>
				</html>
				""";
		mService.sendHtmlMail("fishman4535@gmail.com", "HTML로 메일 전송", html, "dmagkgk919@naver.com");
	}
	
	@Test
	void contextLoads() {
	}

}
