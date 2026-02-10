package com.sist.web.service;

import org.springframework.stereotype.Service;

import com.sist.web.dto.MemberDTO;
import com.sist.web.entity.MemberEntity;
import com.sist.web.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	
	private final MemberRepository mRepository;

	@Override
	public MemberDTO memberLogin(String id, String pwd) {
		// TODO Auto-generated method stub
		
		MemberDTO m = new MemberDTO();
		int count = mRepository.memberIdCount(id);
		if(count == 0) {
			m.setMsg("NOID");
		}
		else {
			MemberEntity me = mRepository.memberGetPassword(id);
			if(pwd.equals(me.getPwd())) {
				m.setId(id);
				m.setName(me.getName());
				m.setMsg("OK");
			}
			else {
				m.setMsg("NOPWD");
			}
		}
		
		return m;
	}
	
	
}
