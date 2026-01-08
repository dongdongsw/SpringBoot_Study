package com.sist.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.FoodService;
import com.sist.web.vo.FoodVO;

import lombok.RequiredArgsConstructor;

/* 	화면 변경 => 요청 처리
 * 
 * 	1. MVC 동작 과정
 * 	2. 어노테이션 역할
 * 		=> 메모리 할당
 * 	3. ORM (Mybatis)
 * 	4. HttpSession / Cookie 처리
 * 	5. 요청 데이터 => @RequestParam / @ModelAttribute
 * 					Vue , React (JSON) => @RequestBody
 * 	6. @Controller / @RestController
 * 	7. @ControlerAdvice : 예외 처리 공통으로 처리
 * 	8. @Aspect : aop 
 * 	9. interceptor
 * 	10. FileUpload
 * 	------------------------------------------------------
 * 	11. Security / Betch / WebSocket / NodeJS
 * 
 * 											-------------------- typescript
 * 	FullStack : javascript / 	Jquery /  	Vue / 			React
 * 								|			 |				  |
 * 							  Ajax	  	 Vuex/pinia		Redux / tanstackquery
 * 
 */

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final FoodService fService;
	

	@GetMapping("/")
	public String main_page(@RequestParam(name="page", required=false) String page, Model model) {
		
		if(page == null) {
			page="1";
		}
		
		int curpage = Integer.parseInt(page);
		int start = (curpage-1)*12;
		
		List<FoodVO> list = fService.FoodListData(start);  
		int totalpage = fService.foodTotalPage();
		
		final int BLOCK=10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage > totalpage) {
			endPage=totalpage;
		}
		
		
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("list",list);
		
		
		model.addAttribute("main_html", "main/home");
		return "main/main";
	}
	
}
