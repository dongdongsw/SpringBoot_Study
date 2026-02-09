package com.sist.web.service;

import java.util.List;

import com.sist.web.dto.CommonsDTO;

public interface TravelService {

	// 서울
	public CommonsDTO seoulMainData();
	public List<CommonsDTO> seoulListData4();
	
	// 부산
	public List<CommonsDTO> busanListData4();
	
	// 제주
	public List<CommonsDTO> jejuListData5();
}
