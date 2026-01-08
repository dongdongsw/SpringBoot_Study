package com.sist.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.sist.web.service.CustomUserDetailService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
/*
 * 	/member/** permitAll
 * 	/admin/** hasRole("ROLE_ADMIN") -> 관리자 페이지
 * 	/board/** hasAnyRole("ROLE_USER","ROLE_ADMIN")
 * 
 */

public class SecurityConfig {

	private final CustomUserDetailService userDetailService;
	
	// 재정의 => 권한에 따라 접근 여부, 로그인 처리 , 로그아웃 처리 / 자동 로그인
	/*
	 * csrf
	 * Cross site Request forgery
	 * =>  공격자가 인증된 브라우저에서
	 * 		저장된 쿠키나 세션정보를 활용해서 웹서버에 사용자가 의도하지 않는
	 * 		요청을 전달 => 위조 방지 : JWT
	 * 		=> 일반 보안 => csrf.disable()
	 * 
	 * authorizeHttpRequests : 인증 , 인가가 필요한 URL을 지정
	 * 
	 * requestMatchers : URL 마다 권한 지정
	 * 
	 * anyRequest() : requestMatchers 지정된  URL외의 처리
	 * 		| denyAll() , permitAll()
	 * 						=> 누구나 접근이 가능
	 * 		=> 접근 거부 (403)
	 * 	=> authenticated() => 해당 URL에 접근시에 인증을 거쳐야 된다
	 * 										  ---
	 * 											| 로그인
	 * 											| 인가 => 누가 어디에 접근할 수 있는지
	 * 	=> hasRole("ROLE_ADMIN")
	 * 	=> hasAnyRole("ROLE_ADMIN")
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http
			.csrf(csrf->csrf.disable())
			.authorizeHttpRequests(auth->auth
					.requestMatchers("/","/join","/login").permitAll()
					.requestMatchers("/user").authenticated()
					.requestMatchers("/admin").hasRole("ADMIN")
					.anyRequest().permitAll() // 게스트를 포함
					)
			// 로그인
			.formLogin(form->form
					.loginPage("/login")
					.loginProcessingUrl("/login")
					.defaultSuccessUrl("/", true)
					.failureHandler(loginFailHandler())
					)
			
			// 로그아웃 => invalidate 포함 => cookie는 사용자가 삭제해야된다
			.logout(logout -> logout
					.logoutSuccessUrl("/")
					)
		
			// 자동 로그인
			.rememberMe(remember-> remember
					.key("remember-me-key")
					.tokenValiditySeconds(60*60*24*7)
					.userDetailsService(userDetailService)
					);
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationFailureHandler loginFailHandler() {
		
		return new LoginFailHandler();
	}
}
