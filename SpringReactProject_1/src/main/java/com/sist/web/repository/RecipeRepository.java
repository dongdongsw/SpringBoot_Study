package com.sist.web.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.RecipeEntity;
import com.sist.web.vo.RecipeListVO;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer>{

	// public List<RecipeListVO> findAll(Pageable pg);
	// count / delete / save(insert) / save(update)
	
	
}
