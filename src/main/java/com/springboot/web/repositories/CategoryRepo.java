package com.springboot.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.entities.Category;


public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
