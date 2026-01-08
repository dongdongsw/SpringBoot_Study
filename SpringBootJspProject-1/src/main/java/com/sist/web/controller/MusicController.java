package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.MusicService;
import com.sist.web.vo.MusicVO;

/*
 * JSP === MVC === SpringFramework === SpringBoot
 * JavaScript === JQuery === Vue === React === Next
 */

@Controller
public class MusicController {

	@Autowired
	private MusicService mService;
	
	@GetMapping("/")
	public String music_list(@RequestParam(name="page", required=false) String page, Model model) {
		
		if(page==null) {
			page="1";
		}
		int curpage = Integer.parseInt(page);
		int rowSize = 12;
		int start = (curpage-1)*rowSize+1;
		int end = curpage*rowSize;
		
		Map map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		List<MusicVO> list = mService.musicListData(map);
		int totalpage = mService.musicTotalPage();
		
		final int BLOCK = 10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1; 
		int endPage =  ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage > totalpage) {
			endPage = totalpage;
		}
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		return "main";
	}
	
}
