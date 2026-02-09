package com.sist.web.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sist.web.entity.RecipeEntity;
import com.sist.web.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService{
	
	private final RecipeRepository rRepository;

	@Override
	public Page<RecipeEntity> findAll(Pageable pg) {
		// TODO Auto-generated method stub
		return rRepository.findAll(pg);
	}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return (int)(Math.ceil(rRepository.count()/12.0));
	}

}
