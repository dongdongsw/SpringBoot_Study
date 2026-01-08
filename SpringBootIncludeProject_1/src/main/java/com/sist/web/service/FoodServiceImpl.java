package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.mapper.FoodMapper;
import com.sist.web.vo.FoodVO;

import lombok.RequiredArgsConstructor;

/*
 * @Autowired
 * private FoodMapper mapper;
 * 
 * private FoodMapper mapper;
 * @Autowired
 * public FoodServiceImpl(FoodMapper mapper){
 * 	this.mapper = mapper;
 * }
 * 
 */

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{

	private final FoodMapper mapper;

	@Override
	public List<FoodVO> FoodListData(int start) {
		// TODO Auto-generated method stub
		return mapper.FoodListData(start);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		return mapper.foodTotalPage();
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		
		mapper.hitIncrement(fno);
		
		return mapper.foodDetailData(fno);
	}

	@Override
	public List<FoodVO> foodFindData(Map map) {
		// TODO Auto-generated method stub
		return mapper.foodFindData(map);
	}

	@Override
	public int foodFindTotalPage(Map map) {
		// TODO Auto-generated method stub
		return mapper.foodFindTotalPage(map);
	}
	
	
}
