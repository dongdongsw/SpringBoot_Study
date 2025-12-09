package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.RecipeService;
import com.sist.web.vo.RecipeVO;

@Controller // 화면 지정 => @RestController
//						   ---- 다른 언어에 데이터 전송
//						   ---- 웹 / 앱 ==> JSON
//						   Spring kotlin 가능자
public class RecipeController {
	// 필요한 객체 생성 => @Autowired => 멤버 변수에만 적용
	//							  => 매개 변수에만 적용
	
	private RecipeService rService;
	// oop가 깨진다 (객체 지향이 꺠진다)
	
	@Autowired
	public RecipeController(RecipeService rService) {
		this.rService = rService;
	}
	
	@GetMapping("/recipe/list")
	public String recipe_list(@RequestParam(name="page", required=false) String page, Model model) {
		// required = false : null 허용
		if(page==null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		int rowSize=12;
		int start = (rowSize*curpage)-(rowSize-1);
		int end = rowSize*curpage;
		
		Map map = new HashMap();
		
		map.put("start", start);
		map.put("end", end);
		
		List<RecipeVO> list = rService.recipeListData(map);
		int totalpage = rService.recipeTotalPage(); 
		
		final int BLOCK=10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage > totalpage) {
			endPage = totalpage;
		}
		
		model.addAttribute("list",list);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("curpage",curpage);
		
		return "recipe/list";
	}
}
