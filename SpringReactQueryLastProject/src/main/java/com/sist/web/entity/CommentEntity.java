package com.sist.web.entity;

import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="comment_1")
@Data
@DynamicUpdate
@DynamicInsert
public class CommentEntity {
	
	@Id
	private int no;
	@Column(insertable = true, updatable = false)
	private int cno;
	@Column(insertable = true, updatable = false)
	private String id;
	@Column(insertable = true, updatable = false)
	private String name;
	private String msg;
	@Column(insertable = true, updatable = false)
	private Date regdate;
	

}
