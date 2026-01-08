package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.EmpVO;

@Mapper
@Repository
public interface EmpMapper {

	@Select("SELECT empno, ename, job, sal, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday "
			+ "FROM emp ORDER BY empno ASC") 
	public List<EmpVO> empListData();
	// JOIN / SubQuery / 동적 쿼리 이용 => XML
}
