package com.sist.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sist.web.vo.MusicVO;

@Mapper
public interface MusicMapper {

	
	 /*
	    * <select id="musicListData" resultType="com.sist.web.vo.MusicVO" parameterType="hashmap">
	       SELECT no,title,poster,singer,num
	       FROM (SELECT no,title,poster,singer,rownum as num
	       FROM (SELECT no,title,poster,singer
	       FROM genie_music ORDER BY no ASC))
	       WHERE num BETWEEN #{start} AND #{end}
	     </select>
	     <select id="musicTotalPage" resultType="int">
	       SELECT CEIL(COUNT(*)/12.0) FROM genie_music
	     </select>
	  */
	
	public List<MusicVO> musicListData(Map map);
	public int musicTotalPage();
	
}
