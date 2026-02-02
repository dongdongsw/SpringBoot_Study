package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.repository.FoodRepository;
import com.sist.web.vo.FoodListVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{

	private final FoodRepository foodRepo;

	@Override
	public List<FoodListVO> foodListData(int start) {
		// TODO Auto-generated method stub
		return foodRepo.foodListData(start);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		
		 return (int)(Math.ceil(foodRepo.count() / 12.0));
	}
	
}
