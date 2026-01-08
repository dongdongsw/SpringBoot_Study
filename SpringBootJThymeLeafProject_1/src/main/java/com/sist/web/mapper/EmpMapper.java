package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.EmpVO;

@Mapper
@Repository
public interface EmpMapper {

	/*
	    <select id="empListData" resultType="com.sist.web.vo.EmpVO">
 			SELECT empno, ename, job, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday, sal
 			FROM emp 
 			ORDER BY empno ASC
 		</select>
	 */
	
	public List<EmpVO> empListData();
	
	
}
