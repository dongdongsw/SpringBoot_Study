package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.web.vo.BoardVO;

public interface BoardService {

	/*
	 @Select("SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit "
			+ "FROM springboard "
			+ "ORDER BY no DESC "
			+ "OFFSET #{start} ROWS FETCH NEXT 10 ROWS ONLY")
	public List<BoardVO> boardListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springboard")
	public int boardTotalPage();
	 */
	
	public List<BoardVO> boardListData(int start);
	public int boardTotalPage();
	
	/*
	@Select("SELECT no, subject, name, content, hit, TO_CHAR(regdate, 'YYYY-MM-DD) as dbday "
			+ "FROM springboard "
			+ "WHERE no = #{no}")
	public BoardVO boardDetailData(int no);
	
	@Update("UPDATE springboard SET hit = hit + 1 WHERE no = #{no}")
	public void hitIncrement(int no);
	 */
	public BoardVO boardDetailData(int no);
	
	/*
	@Insert("INSERT INTO springboard VALUES( "
			+ "sb_no_seq.nextval, #{name}, #{subject}, #{content}, "
			+ "#{pwd}, SYSDATE, hit)")
	public void boardInsert(BoardVO vo);
	
	 */
	public void boardInsert(BoardVO vo);
	
	public BoardVO boardUpdateData(int no);
	public boolean boardUpdate(BoardVO vo);
	public boolean boardDelete(int no, String pwd);


	
}
