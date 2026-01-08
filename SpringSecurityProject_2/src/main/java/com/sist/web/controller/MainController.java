package com.sist.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.web.mapper.UsersMapper;
import com.sist.web.vo.UserRolesVO;
import com.sist.web.vo.Users_1VO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final PasswordEncoder pEncoder;
	private final UsersMapper mapper;
	
	@GetMapping("/")
	public String main_page() {
		
		return "main";
	}
	
	@GetMapping("/join")
	public String join() {
		
		return "join";
	}
	
	@PostMapping("/join")
	public String join_ok_page(@ModelAttribute("vo") Users_1VO vo) {
		
		vo.setPassword(pEncoder.encode(vo.getPassword()));
		mapper.userInsert(vo);
		Users_1VO dbVO = mapper.findByUsername(vo.getUsername());
		
		UserRolesVO rvo = new UserRolesVO();
		rvo.setUser_id(dbVO.getId());
		rvo.setRole_name("ROLE_USER");
		mapper.userRoleInsert(rvo);
		
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}

	@GetMapping("/all")
	public String all() {
		
		return "all";
	}

	@GetMapping("/admin")
	public String admin() {
		
		return "adminpage";
	}
	
	@GetMapping("/user")
	public String user_page(@AuthenticationPrincipal UserDetails userDetail, Model model) {
		
		model.addAttribute("id", userDetail.getUsername());
		model.addAttribute("roles", userDetail.getAuthorities());
		
		
		return "mypage";
	}
	
	
	
	
}
