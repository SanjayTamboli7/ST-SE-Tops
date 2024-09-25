package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProductCategory;
import com.example.demo.repository.ProductCategoryRepo;

@Service
public class ProductCategoryService {

	@Autowired
	ProductCategoryRepo productcategoryrepository;

	// ProductCategory productcategory
	public List<ProductCategory> getAllproductcategory() // all data fetch
	{
		List<ProductCategory> productcategory=new ArrayList<ProductCategory>();
		productcategoryrepository.findAll().forEach(productcategory1 -> productcategory.add(productcategory1));
		return productcategory;
	}
	
	public ProductCategory getProductCategoryById(int id) // Single dealer fetch
	{
		return productcategoryrepository.findById(id).get(); 
	}

	public void saveOrUpdate(ProductCategory productcategory) // insert new book
	{
		productcategoryrepository.save(productcategory);
	}

	public void delete(int id) 
	{
		productcategoryrepository.deleteById(id);
	}
	
	public void update(ProductCategory productcategory, int productcategoryid) 
	{
		productcategoryrepository.save(productcategory);
	}	

}
