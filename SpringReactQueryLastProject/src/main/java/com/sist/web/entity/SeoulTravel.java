package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/*
	NO          NOT NULL NUMBER         
TITLE                VARCHAR2(1024) 
IMAGE1               VARCHAR2(1024) 
IMAGE2               VARCHAR2(1024) 
X                    NUMBER(20,12)  
Y                    NUMBER(20,12)  
CONTENTID            NUMBER         
ADDRESS              VARCHAR2(300)  
CONTENTTYPE          NUMBER(2)      
HIT                  NUMBER 
*/

@Entity
@Table(name = "seoultravel")
@Data
public class SeoulTravel {

	@Id
	@Column(name = "contentid")
	private int contentid;
	
	private int no;
	private String title;
	private String image1;
	private String image2;
	private String address;
	private double x;
	private double y;
	private int contenttype;
	private int hit;
}
