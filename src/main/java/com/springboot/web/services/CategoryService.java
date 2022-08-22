package com.springboot.web.services;

import java.util.List;

import com.springboot.web.payloads.CategoryDto;

public interface CategoryService {

//	by default methods in interface are public
	
//	create
	CategoryDto createCategory(CategoryDto categoryDto);
	
//	update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	
//	delete
	void deleteCategory(Integer categoryId);
	
//	get
	CategoryDto getCategory(Integer categoryId);
	
	
	//get all
	List<CategoryDto> getCategories();
}
