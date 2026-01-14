package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sist.web.service.DataBoardService;
import com.sist.web.vo.DataBoardVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/databoard/")
@RequiredArgsConstructor
public class DataBoardRestController {

	private final DataBoardService dService;
	
	@DeleteMapping("delete_ok/")
	public String databoard_delete_ok(@RequestParam("no") int no, @RequestParam("pwd") String pwd, HttpServletRequest request) {
		
		String res = "";
		DataBoardVO vo = dService.databoardFileInfo(no);
		res = dService.databoardDelete(no, pwd);	
		if(res.equals("yes")) {
			try {
				if(vo.getFilecount() != 0) {
					String delDif = request.getServletContext().getRealPath("/upload");
					StringTokenizer st = new StringTokenizer(vo.getFilename(),",");
					while(st.hasMoreTokens()) {
						File file = new File(delDif + "/" + st.nextToken());
						file.delete();
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				
			}
		}
		
		return res;
	}
}
