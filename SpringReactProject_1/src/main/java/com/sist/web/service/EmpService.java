package com.sist.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.sist.web.entity.Emp;
import com.sist.web.vo.EmpDeptVO;

public interface EmpService {
/*
 @Query("""
			SELECT e
			FROM Emp e
			JOIN e.dept d
			WHERE d.deptno = :deptno
			""")
	public List<Emp> findByDeptDeptno();
	
	@Query("""
			SELECT new com.sist.web.vo.EmpDeptVO(
				e.empno, e.ename, d.dname, d.loc, e.job
			)
			FROM Emp e
			JOIN e.dept d
			WHERE d.deptno = e.deptno
			""")
	public List<EmpDeptVO> findEmpDeptVO();
 */
	
	public List<Emp> findByDeptDeptno();
	public List<EmpDeptVO> findEmpDeptVO();
}
