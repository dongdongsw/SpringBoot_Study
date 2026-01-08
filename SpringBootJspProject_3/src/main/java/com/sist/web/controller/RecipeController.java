package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.RecipeService;
import com.sist.web.vo.RecipeDetailVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RecipeController {

	private RecipeService rService;
	
	@GetMapping("/recipe/list")
	public String recipe_list() {
		
		return "recipe/list";
	}
	
	@GetMapping("/recipe/detail")
	public String recipe_detail(@RequestParam("no") int no, Model model) {
		
		
		model.addAttribute("no",no);
		return "recipe/detail";
	}
}
