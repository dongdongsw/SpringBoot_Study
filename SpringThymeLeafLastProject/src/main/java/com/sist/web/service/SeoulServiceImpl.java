package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.SeoulMapper;
import com.sist.web.vo.SeoulVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeoulServiceImpl implements SeoulService{
/*
 * 	@Autowired
 * 	public SeoulServiceImpl(SeoulMapper mapper){
 * 		this.mapper = mapper;
 *  }
 * 
 */
	
	
	private final SeoulMapper mapper;

	@Override
	public List<SeoulVO> seoulMainData(Map map) {
		// TODO Auto-generated method stub
		return mapper.seoulMainData(map);
	}
	
}
