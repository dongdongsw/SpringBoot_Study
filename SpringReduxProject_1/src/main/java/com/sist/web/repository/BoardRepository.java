package com.sist.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.BoardEntity;
import com.sist.web.vo.BoardDTO;


public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{

	@Query(value ="""
			SELECT no, subject, name, hit, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday 
			FROM board_1
			ORDER BY no DESC
			OFFSET :start ROWS FETCH NEXT 10 ROWS ONLY
			""", nativeQuery = true)
	public List<BoardDTO> boardListData(@Param("start") int start);
	
	@Query(value = """
			SELECT NVL(MAX(no)+1,1) FROM board_1	
			""", nativeQuery = true)
	public void boardNoMax();
	
	public BoardEntity findByNo(int no);
	// count()
	
	// insert => save()
}
