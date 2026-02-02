package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="recipe2")
@Data
public class RecipeEntity {
	@Id
	private int no;
	
	private int hit, likecount, jjimcount, replycount;
	private String title, poster, chef, link;
}
