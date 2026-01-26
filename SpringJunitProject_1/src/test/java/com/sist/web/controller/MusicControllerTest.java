package com.sist.web.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.MusicService;
import com.sist.web.vo.MusicVO;

@WebMvcTest(MusicController.class)
public class MusicControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MusicService mService;
	
	@Test
	@DisplayName("뮤직 페이지 목록 조회")
	void music_list () throws Exception{
		
		int page = 1;
		int curpage = page;
		List<MusicVO> list = mService.musicListData((curpage-1)*20);
		int totalpage = mService.musicTotalPage();
		
		assertThat(list).isNotNull();
		//assertThat(list.size()).isLessThan(20);
		assertThat(list.get(0).getNo()).isGreaterThan(21);
		System.out.println(list);
		System.out.println(list.get(0).getNo());
	}
}
