package com.sist.web.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.FoodEntity;
import com.sist.web.vo.FoodDTO;

public interface FoodService {
	
	//리스트
	public List<FoodDTO> foodListData(int start);
	public int foodTotalPage();
	// 상세보기
	public FoodEntity findByFno(int fno);
}
