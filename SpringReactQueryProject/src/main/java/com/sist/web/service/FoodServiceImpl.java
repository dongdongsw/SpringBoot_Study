package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.dto.FoodDTO;
import com.sist.web.entity.FoodEntity;
import com.sist.web.repository.FoodRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{

	private final FoodRepository fRepository;

	@Override
	public List<FoodDTO> foodListData(int start) {
		// TODO Auto-generated method stub
		return fRepository.foodListData(start);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		return (int)(Math.ceil(fRepository.count()/12.0));
	}

	@Override
	public FoodEntity findByFno(int fno) {
		// TODO Auto-generated method stub
		return fRepository.findByFno(fno);
	}
}
