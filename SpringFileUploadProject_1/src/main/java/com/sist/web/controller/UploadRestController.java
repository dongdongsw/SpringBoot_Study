package com.sist.web.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
/*
 * 	1. 객체 주소 주입 : @Autowired / @RequiredArgsConstructor
 * 	2. 변수 값 주입 : @Value("${}") => Properties yml
 * 
 * 
 */
@RestController
// singletin => 주소값 변경이 없음
@RequiredArgsConstructor
public class UploadRestController {

	@Value("${file.upload-dir}")
	private String uploadDir;
	private static int count = 1;
	
	
	@PostMapping("/upload_ok")
	public String upload_ok(@RequestParam("file") MultipartFile file) throws IOException{
		
		if(file.isEmpty()) {
			return "파일이 없습니다.";
		}
			
		String oname = file.getOriginalFilename();
		File files = new File(uploadDir + "/" + oname);
		
		String newName = "";
		
		if(files.exists()) {
			String name = oname.substring(0, oname.lastIndexOf("."));
			String ext = oname.substring(oname.lastIndexOf("."));
			
			newName = name + "(" + count + ")" + ext;
			count++;
		}
		
		Path savePath = Paths.get(uploadDir, newName);
		Files.copy(file.getInputStream(), savePath);
		
		return "업로드 성공" + newName;
		
	}
	
	@PostMapping("/multi_upload")
	public String multi_upload(@RequestParam("files") List< MultipartFile> files) throws IOException{
		
		for(MultipartFile file : files){
			if(files.isEmpty() ) {
				return "파일이 존재하지 않습니다";
			}
			else {
				String oname = file.getOriginalFilename();
				File f = new File(uploadDir + "/" + oname);

				if(f.exists()) {
					String name = oname.substring(0,oname.lastIndexOf("."));
					String ext = oname.substring(oname.lastIndexOf("."));
					// 중복처리
					int count = 1;
					while(f.exists()) {
						String newName = name + "(" + count + ")" + ext;
						f = new File(uploadDir + "/" + newName);
						count++;
					}
					
				}
				Path path = Paths.get(uploadDir,f.getName());
				Files.copy(file.getInputStream(), path);
			}
		}
		
		return "다중 업로드 완료!!";
	}
	
	
}
