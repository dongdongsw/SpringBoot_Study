package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.FoodService;
import com.sist.web.vo.FoodListVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class FoodRestController {

	private final FoodService fService;
	
	@GetMapping("/food/list_react/{page}")
	public ResponseEntity<Map> food_list(@PathVariable("page") int page){
		
		Map map = new HashMap<>();
		try {
			
			List<FoodListVO> list = fService.foodListData((page-1)*12);
			int totalpage = fService.foodTotalPage();
			
			final int BLOCK = 10;
			int startPage = ((page-1)/BLOCK*BLOCK) + 1;
			int endPage = ((page-1)/BLOCK*BLOCK) + BLOCK;
			if(endPage > totalpage) {
				endPage = totalpage;
			}
			
			map.put("list", list);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("totalpage", totalpage);
			map.put("curpage", page);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Map>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Map>(map, HttpStatus.OK);
	}
}
