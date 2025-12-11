package com.sist.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
