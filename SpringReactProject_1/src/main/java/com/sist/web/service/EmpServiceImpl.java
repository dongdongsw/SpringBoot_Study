package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.entity.Emp;
import com.sist.web.repository.EmpRepository;
import com.sist.web.vo.EmpDeptVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService{

	private final EmpRepository eRepository;
	
	@Override
	public List<Emp> findByDeptDeptno() {
		// TODO Auto-generated method stub
		return eRepository.findByDeptDeptno();
	}

	@Override
	public List<EmpDeptVO> findEmpDeptVO() {
		// TODO Auto-generated method stub
		return eRepository.findEmpDeptVO();
	}

}
