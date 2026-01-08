package com.sist.web.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.web.vo.FoodVO;

public interface FoodService {

	/*
	 	@Select("SELECT fno, name, poster "
			+ "FROM menupan_food "
			+ "ORDER BY fno ASC "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<FoodVO> foodListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food")
	public int foodTotalPage();
	 */
	// 맛집 리스트
	public List<FoodVO> foodListData(int start);
	public int foodTotalPage();

	/*
	 @Select("SELECT fno, namme, rownum "
			+ "FROM (SELECT fno, name "
			+ "FROM menupan_food "
			+ "ORDER BY hit DESC) "
			+ "WHERE rownum <= 10")
	public List<FoodVO> foodTop10Data();
	 */
	// Footer에 출력
	public List<FoodVO> foodTop10Data();
	
	// 상세보기
	public FoodVO foodDetailData(int fno);

}
