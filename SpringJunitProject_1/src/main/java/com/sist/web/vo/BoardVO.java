package com.sist.web.vo;

import java.time.LocalDateTime;

import lombok.Data;

/*
no int AI PK 
name varchar(51) 
subject varchar(2000) 
content text 
pwd varchar(10) 
regdate datetime 
hit int
 */
@Data
public class BoardVO {

	private int no, hit;
	private String name, subject, content, pwd, dbday;
	private LocalDateTime regdate;
}
