package com.sist.web.vo;

import lombok.Data;

@Data
public class ChatMessageVO {

	private String type;
	private String sender;
	private String receiver;
	private String message;
	private String time;
}
