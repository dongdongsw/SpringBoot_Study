package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.FoodService;
import com.sist.web.vo.FoodVO;

// SSR / CSR
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class FoodRestController {

	private final FoodService fService;
	
	@GetMapping("/food/detail_vue/")
	public ResponseEntity<FoodVO> food_detail_vue(@RequestParam("fno") int fno) {
		FoodVO vo = new FoodVO();
		try {
			vo = fService.foodDetailData(fno);
		
		}catch (Exception ex) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(vo,HttpStatus.OK);
	}
	
	@RequestMapping("/food/find_vue/")
	public ResponseEntity<Map> food_find(@RequestParam(name="column", required=false) String column, 
			@RequestParam(name="ss", required=false) String ss, 
			@RequestParam(name="page", required=false) String page) {
		
		Map map = new HashMap<>();
		
		try {
			
			if(page==null) {
				page="1";
			}
			int curpage = Integer.parseInt(page);
			if(column == null) {
				column="all";
			}
			
			
			map.put("column", column);
			map.put("ss", ss);
			map.put("start", (curpage*12)-12);
			
			// db 연동
			List<FoodVO> list = fService.foodFindData(map);
			int totalpage = fService.foodFindTotalPage(map);
			
			final int BLOCK= 10;
			int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
			int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
			
			if(endPage > totalpage) {
				endPage = totalpage;
			}
			
			
			
			map.put("list",list);
			map.put("totalpage",totalpage);
			map.put("curpage",curpage);
			map.put("endPage",endPage);
			map.put("startPage",startPage);
			map.put("column",column);
			if(column != null) {
				map.put("ss",ss);
			}
		}
		catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
}
