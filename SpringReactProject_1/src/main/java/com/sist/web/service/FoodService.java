package com.sist.web.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sist.web.vo.FoodListVO;

public interface FoodService {
	List<FoodListVO> foodListData(int start);
	int foodTotalPage();
}
