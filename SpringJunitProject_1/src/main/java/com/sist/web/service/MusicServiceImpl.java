package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.MusicMapper;
import com.sist.web.vo.MusicVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService{

	private final MusicMapper mapper;

	@Override
	public List<MusicVO> musicListData(int start) {
		// TODO Auto-generated method stub
		return mapper.musicListData(start);
	}

	@Override
	public int musicTotalPage() {
		// TODO Auto-generated method stub
		return mapper.musicTotalPage();
	}

	@Override
	public String musicGetTitle(int no) {
		// TODO Auto-generated method stub
		return mapper.musicGetTitle(no);
	}
}
