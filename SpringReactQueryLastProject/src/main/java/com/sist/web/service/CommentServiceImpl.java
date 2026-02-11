package com.sist.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.dto.CommentDTO;
import com.sist.web.entity.CommentEntity;
import com.sist.web.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

	private final CommentRepository cRepository;
	
	@Override
	public List<CommentDTO> commentListData(int contentid) {
		// TODO Auto-generated method stub
		return cRepository.commentListData(contentid);
	}

	@Override
	public List<CommentDTO> commentInsert(CommentEntity vo) {
		// TODO Auto-generated method stub
		int no = cRepository.maxNo();
		vo.setNo(no);
		vo.setRegdate(new Date());
		cRepository.save(vo);
		
		return cRepository.commentListData(vo.getCno());
	}

	@Override
	public List<CommentDTO> commentDelete(int no, int cno) {
		// TODO Auto-generated method stub
		
		CommentEntity vo = cRepository.findByNo(no);
		cRepository.delete(vo);
		
		return cRepository.commentListData(cno);
	}

	@Override
	public List<CommentDTO> commentUpdate(int no, String msg) {
		// TODO Auto-generated method stub
		CommentEntity vo = cRepository.findByNo(no);
		vo.setMsg(msg);
		vo.setNo(no);
		cRepository.save(vo);
		
		return cRepository.commentListData(vo.getCno());
	}
	

}
