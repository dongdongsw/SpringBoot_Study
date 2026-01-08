package com.sist.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.RecipeService;
import com.sist.web.vo.RecipeDetailVO;
import com.sist.web.vo.RecipeVO;
import com.sist.web.vo.SeoulVO;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

/*
	1. 전송 / 처리 / 결과값 출력
	  	-------------------
	  	| 요청값 		 | 결과값
	  	------		  ------
*/
@Controller
@RequiredArgsConstructor
@RequestMapping("/recipe/")
public class RecipeController {

	private final RecipeService rService;
	
	
	
	@GetMapping("list")
	public String recipe_list(@RequestParam(name="page", required=false) String page, Model model) {
		
		if(page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		int start = (curpage * 12) - 12;
		
	
		
		List<RecipeVO> list= rService.recipeListData(start);
		
		int totalpage = rService.recipeTotalPage();
		
		final int BLOCK = 10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage > totalpage) {
			endPage = totalpage;
		}
		
		model.addAttribute("list", list);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("curpage", curpage);
		
		model.addAttribute("main_html","recipe/list");
		return "main/main";
	}

	@GetMapping("detail")
	public String recipe_detail(@RequestParam("no") int no, Model model, HttpSession session) {
		
		RecipeDetailVO vo = rService.recipeDetailData(no);
		List<String> mList = new ArrayList<String>();
		List<String> nList = new ArrayList<String>();
		String[] datas = vo.getFoodmake().split("\n");
		for(String s : datas) {
			StringTokenizer st = new StringTokenizer(s,"^");
			mList.add(st.nextToken());
			nList.add(st.nextToken());
			
		}
		String id = (String)session.getAttribute("id");
		if(id==null) {
			model.addAttribute("sessionId","");
		}
		else {
			model.addAttribute("sessionId",id);
		}
		
		model.addAttribute("mList", mList);
		model.addAttribute("nList", nList);
		
		model.addAttribute("vo", vo);
		
		model.addAttribute("main_html","recipe/detail");
		return "main/main";
	}	
	
	@GetMapping("chef_list")
	public String recipe_chef_list(@RequestParam(name="page", required=false) String page, @RequestParam("chef") String chef, Model model) {
		
		if(page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		int start = (curpage * 12) - 12;
		
		List<RecipeVO> list= rService.recipeChefListData(start,chef);
		
		int totalpage = rService.recipeChefTotalPage(chef);
		
		final int BLOCK = 10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage > totalpage) {
			endPage = totalpage;
		}
		
		model.addAttribute("list", list);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("curpage", curpage);

		model.addAttribute("chef", chef);
		
		
		model.addAttribute("main_html","recipe/chef_list");
		return "main/main";
	}
	
	
	
	
	
	
	
	
	@GetMapping("search")
	public String recipe_search(@RequestParam(name="page", required=false) String page, Model model) {
		

		model.addAttribute("main_html","recipe/search");
		return "main/main";
	}	
	
	
	
	@GetMapping("recommend")
	public String recipe_recommend(@RequestParam(name="page", required=false) String page, Model model) {
		

		model.addAttribute("main_html","recipe/recommend");
		return "main/main";
	}
}
