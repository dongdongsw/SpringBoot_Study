package com.sist.web.service;

import java.util.List;
import java.util.Map;

import com.sist.web.vo.BoardVO;

public interface BoardService {

	// 리스트
	public List<BoardVO> boardListData(Map map);
	
	public int boardCountRow();
	
	// 작성
	public void boardInsert(BoardVO vo);
	
	public BoardVO boardDetailData(int no);
	
	// 수정
	public BoardVO boardUpdateData(int no);
	
	public boolean boardUpdate(BoardVO vo);

	// 답변
	public void boardReplyInsert(BoardVO vo, int pno);
	
	// 삭제
	public boolean boardDelete(int no, String pwd);


}
