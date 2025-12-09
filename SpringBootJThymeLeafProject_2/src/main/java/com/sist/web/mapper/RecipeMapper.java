package com.sist.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.RecipeVO;

@Mapper
@Repository
public interface RecipeMapper {

	/*
		 <select id="recipeListData" resultType="com.sist.web.vo.RecipeVO"
	 		parameterType="hashmap"
	 	>
	 		SELECT no, title, chef, poster, num
	 		FROM (SELECT no, title, chef, poster, rownum as num
	 		FROM (SELECT no, title, chef, poster
	 		FROM recipe
	 		WHERE no IN (
	 			SELECT no 
	 			FROM recipe INTERSECT SELECT no FROM recipedetail)
	 		ORDER BY no ASC))
	 		WHERE num BETWEEN #{start} AND #{end}
	 	</select>
	 	
	 	<select id="recipeTotalPage" resultType="int">
	 		SELECT CEIL(COUNT(*)/12.0) FROM recipe
	 		WHERE no IN (
	 			SELECT no 
	 			FROM recipe INTERSECT SELECT no FROM recipedetail)
	 	</select>
	 	
	 	<select id="recipeTop10" resultType="com.sist.web.vo.RecipeVO"
	 		parameterType="hashmap"
	 	>
	 		SELECT no, title, chef, poster, num
	 		FROM (SELECT no, title, chef, poster, rownum as num
	 		FROM (SELECT no, title, chef, poster
	 		FROM recipe
	 		WHERE no IN (
	 			SELECT no 
	 			FROM recipe INTERSECT SELECT no FROM recipedetail)
	 		ORDER BY hit DESC))
	 		WHERE num&lt;=10
	 	</select>
	 */
	
	public List<RecipeVO> recipeListData(Map map);
	
	public int recipeTotalPage();
	
	public List<RecipeVO> recipeTop10();
	
}
