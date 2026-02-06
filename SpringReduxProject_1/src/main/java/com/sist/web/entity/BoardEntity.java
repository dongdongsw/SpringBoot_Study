package com.sist.web.entity;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.tool.schema.extract.internal.SequenceNameExtractorImpl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "board_1")
@Data
@DynamicUpdate
@DynamicInsert
@SequenceGenerator(
		name = "BR1_NO_SEQ",
		sequenceName = "BR1_NO_SEQ",
		allocationSize = 1
		)
public class BoardEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BR1_NO_SEQ")
	private int no;
	
	private String name;
	private String subject;
	private String content;
	
	@Column(insertable = true, updatable = false)
	private String pwd;
	
	@Column(insertable = true, updatable = false)
	@ColumnDefault("SYSDATE")
	private Date regdate;
	
	@ColumnDefault("0")
	private int hit;
	
	@ColumnDefault("0")
	private int replycount;
}
