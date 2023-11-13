package com.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.payloads.CategoryDto;


public interface CategoryService {

	// create
	CategoryDto createCategory(CategoryDto categoryDto);

	// Update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	// Delete
	public void deleteCategory(Integer categoryId);

	// get

	public CategoryDto getCategory(Integer categoryId);

	// getAll
	List<CategoryDto> getCategories();

}
