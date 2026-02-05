package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sist.web.entity.RecipeDetailEntity;

public interface RecipeDetailRepository extends JpaRepository<RecipeDetailEntity, Integer>{

	public RecipeDetailEntity findByNo(int no);
	/*
	 * SELECT * FROM recipedetail where no = 10 (매개변수값)
	 */
}
