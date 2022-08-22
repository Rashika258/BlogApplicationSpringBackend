package com.springboot.web.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.entities.Category;
import com.springboot.web.exceptions.ResourceNotFoundException;
import com.springboot.web.payloads.CategoryDto;
import com.springboot.web.repositories.CategoryRepo;
import com.springboot.web.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);
        Category addedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(addedCat, CategoryDto.class);

    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
            .orElseThrow(() -> new ResourceNotFoundException("Category ", "Category Id", categoryId));
        cat.setCategoryDescription(categoryDto.getCategoryDescription());
        cat.setCategoryTitle(categoryDto.getCategoryTitle());

        Category updatedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(updatedCat, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ", "Category Id", categoryId));
        this.categoryRepo.delete(cat);
    }

//    get category by id
    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ", "Category Id", categoryId));

        return this.modelMapper.map(cat, CategoryDto.class);

    }

//    get all categories
    @Override
    public List < CategoryDto > getCategories() {
        List < Category > categories = this.categoryRepo.findAll();
        List < CategoryDto > catDtos = categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
        return catDtos;

    }

}