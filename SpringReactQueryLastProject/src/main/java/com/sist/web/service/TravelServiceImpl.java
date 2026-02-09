package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.dto.CommonsDTO;
import com.sist.web.repository.BusanTravelRepository;
import com.sist.web.repository.JejuTravelRepository;
import com.sist.web.repository.SeoulTravelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService{
	
	private final SeoulTravelRepository sRepository;
	private final BusanTravelRepository bRepository;
	private final JejuTravelRepository jRepository;
	
	@Override
	public CommonsDTO seoulMainData() {
		// TODO Auto-generated method stub
		return sRepository.seoulMainData();
	}

	@Override
	public List<CommonsDTO> seoulListData4() {
		// TODO Auto-generated method stub
		return sRepository.seoulListData4();
	}
	
	@Override
	public List<CommonsDTO> busanListData4() {
		// TODO Auto-generated method stub
		return bRepository.busanListData4();
	}

	@Override
	public List<CommonsDTO> jejuListData5() {
		// TODO Auto-generated method stub
		return jRepository.jejuListData5();
	}

	

}
