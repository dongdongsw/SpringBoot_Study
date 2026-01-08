package com.sist.web.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.web.mapper.MusicMapper;
import com.sist.web.vo.MusicVO;

@Repository
public class MusicDAO {

	@Autowired
	private MusicMapper mapper;
	

	public List<MusicVO> musicListData(Map map){
		return mapper.musicListData(map);
	}
	public int musicTotalPage() {
		return mapper.musicTotalPage();
	}
	
}
