package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/*
 * 
 * FNO           NUMBER(38)     
NAME          VARCHAR2(4000) 
TYPE          VARCHAR2(4000) 
PHONE         VARCHAR2(26)   
ADDRESS       VARCHAR2(4000) 
SCORE         NUMBER(38,1)   
THEME         VARCHAR2(4000) 
PRICE         VARCHAR2(26)   
TIME          VARCHAR2(128)  
PARKING       VARCHAR2(128)  
POSTER        VARCHAR2(4000) 
IMAGES        VARCHAR2(4000) 
CONTENT       VARCHAR2(4000) 
HIT           NUMBER(38)     
JJIMCOUNT     NUMBER(38)     
LIKECOUNT     NUMBER(38)     
REPLYCOUNT    NUMBER(38)   
 */
// 테이블 연결
@Entity(name ="menupan_food")
@Data
public class FoodEntity {
   @Id
   //@Column(name="fno") 이렇게 하고 no로 하면 된다.	
   private int  fno;
   
   private String name,type,phone,address,theme,price,time,parking,poster,images,content;
   private int hit,jjimcount,likecount,replycount;
   private double score;
}
