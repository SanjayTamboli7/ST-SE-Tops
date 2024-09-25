package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ProductCategory;

public interface ProductCategoryRepo extends CrudRepository<ProductCategory, Integer> {

}
