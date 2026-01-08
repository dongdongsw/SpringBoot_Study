package com.sist.web.service;

import java.util.List;
import java.util.Map;


import com.sist.web.vo.FoodVO;

public interface FoodService {
	/*
		 @Select("SELECT fno, name, poster, address "
				+ "FROM menupan_food "
				+ "ORDER BY fno ASC "
				+ "OFFSET #{start} ROWS FETCH 12 ROWS ONLY")
		public List<FoodVO> FoodListData(int start);
		
		@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food")
		public int foodTotalPage(); 
	 */
	public List<FoodVO> FoodListData(int start);
	public int foodTotalPage();
	
	/*
	 	@Update("UPDATE menupan_food SET "
				+ "hit = hit + 1 "
				+ "WHERE no = #{no}")
		public void hitIncrement(int fno);
		
		@Select("SELECT fno, name, poster, address, phone, time, parking, "
				+ "theme, score, type, content, price "
				+ "FROM menupan_food "
				+ "WHERE fno = #{fno}")
		public FoodVO foodDetailData(int fno);
	 */
	public FoodVO foodDetailData(int fno);
	
	// 검색
	public List<FoodVO> foodFindData(Map map);
	
	public int foodFindTotalPage(Map map);
}
