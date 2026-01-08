package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Update;

import com.sist.web.vo.FoodVO;

public interface FoodService {

	public List<FoodVO> foodListData(Map map);
	public int foodTotalPage();
	public FoodVO foodDetailData(Map map);
	public List<FoodVO> foodFindData(Map map);
	public int foodFindTotalPage(Map map);
}
