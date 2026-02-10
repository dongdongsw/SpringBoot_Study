package com.sist.web.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.dto.MemberDTO;
import com.sist.web.entity.MemberEntity;

public interface MemberService {

	public MemberDTO memberLogin(String id, String pwd);
}
