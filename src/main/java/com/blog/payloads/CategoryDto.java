package com.blog.payloads;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	
	

	private Integer categoryId;
	
	@NotNull
	private String categoryTitle;
	
	@NotNull
	@Size(min=20)
	private String categoryDescription;

	
}
