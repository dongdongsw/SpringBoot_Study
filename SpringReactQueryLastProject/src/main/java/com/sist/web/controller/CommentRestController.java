package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dto.CommentDTO;
import com.sist.web.entity.CommentEntity;
import com.sist.web.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class CommentRestController {

	private final CommentService cService;
	
	@PostMapping("/comment/insert")
	public ResponseEntity<Map> comment_insert(@RequestBody CommentEntity vo){

		Map map = new HashMap<>();
		
		try {
			List<CommentDTO> list = cService.commentInsert(vo);
						
			map.put("comments", list);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
	//	@DeleteMapping
	@PostMapping("/comment/delete/{no}/{cno}")
	public ResponseEntity<Map> comment_delete(@PathVariable("no") int no, @PathVariable("cno") int cno){

		Map map = new HashMap<>();
		
		try {
			List<CommentDTO> list = cService.commentDelete(no,cno);
						
			map.put("comments", list);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	// 	@PutMapping
	@PutMapping("/comment/update")
	public ResponseEntity<Map> comment_update(@RequestBody CommentEntity vo){

		Map map = new HashMap<>();
		
		try {
			List<CommentDTO> list = cService.commentUpdate(vo.getNo(), vo.getMsg());
						
			map.put("comments", list);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
