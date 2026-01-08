package com.sist.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.FoodVO;

@Repository
@Mapper
public interface FoodMapper {

	@Select(value="{CALL foodListData(#{pStart, mode=IN, javaType=java.lang.Integer}, "
			+ "#{pResult, mode=OUT, jdbcType = CURSOR, resultMap = foodMap})} ")
	@Options(statementType = StatementType.CALLABLE)
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food")
	public int foodTotalPage();
	
	@Select(value="{CALL foodDetailData(#{pNo, mode=IN, javaType=java.lang.Integer}, "
			+ "#{pResult, mode=OUT, jdbcType = CURSOR, resultMap = detailMap})} ")
	@Options(statementType = StatementType.CALLABLE)
	public FoodVO foodDetailData(Map map);
	
	@Update("UPDATE menupan_food SET "
			+ "hit = hit + 1 "
			+ "WHERE fno = #{fno}")
	public void foodHitIncrement(int fno);
	
	// 검색
	public List<FoodVO> foodFindData(Map map);
	public int foodFindTotalPage(Map map);
}
