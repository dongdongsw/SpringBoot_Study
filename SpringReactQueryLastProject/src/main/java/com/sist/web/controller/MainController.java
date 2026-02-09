package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dto.CommonsDTO;
import com.sist.web.service.TravelService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class MainController {

	private final TravelService tService;
	
	@GetMapping("/")
	public ResponseEntity<Map> main_page(){
		Map map = new HashMap<>();
		
		try {
			CommonsDTO mainData = tService.seoulMainData();
			List<CommonsDTO> seoulData = tService.seoulListData4();
			List<CommonsDTO> busanData = tService.busanListData4();
			List<CommonsDTO> jejuData = tService.jejuListData5();
			 
			map.put("main", mainData);
			map.put("sList", seoulData);
			map.put("bList", busanData);
			map.put("jList", jejuData);
			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
