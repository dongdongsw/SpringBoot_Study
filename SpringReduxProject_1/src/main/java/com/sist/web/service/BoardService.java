package com.sist.web.service;

import java.util.List;

import com.sist.web.entity.BoardEntity;
import com.sist.web.vo.BoardDTO;

public interface BoardService {
	public List<BoardDTO> boardListData( int start);
	public int boardTotalPage();
	public void boardInsert(BoardEntity vo);
	
//	public void boardNoMax();
	public BoardEntity findByNo(int no);
	public BoardEntity boardUpdateData(int no);
	public String boardUpdateOk(BoardEntity vo);
	public String boardDelete(int no, String pwd);
}
