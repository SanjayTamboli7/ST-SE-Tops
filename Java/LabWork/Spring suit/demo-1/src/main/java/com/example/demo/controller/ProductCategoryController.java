package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductCategory;
import com.example.demo.service.ProductCategoryService;

@RestController
public class ProductCategoryController {

	@SuppressWarnings("unused")
	@Autowired
	ProductCategoryService productcategoryservice;
	@GetMapping("/productcategory")
	private List<ProductCategory> getAllProductCategory() {
		return productcategoryservice.getAllproductcategory();
	}
	
	@GetMapping("productcategory/{productcategoryid}")
	private ProductCategory getproductcategory(@PathVariable("productcategoryid") int productcategoryid) {
		return productcategoryservice.getProductCategoryById(productcategoryid);
	}

	@DeleteMapping("productcategory/{productcategoryid}")
	private void deletproductcategory(@PathVariable("productcategoryid") int productcategoryid) {
		productcategoryservice.delete(productcategoryid);
	}

	// ProductCategory productcategory
	@PostMapping("/productcategory")
	private int saveProductCategory(@RequestBody ProductCategory productcategory) {
		productcategoryservice.saveOrUpdate(productcategory);
		return productcategory.getPcid();
	}

	@PutMapping("/productcategory")
	private ProductCategory update(@RequestBody ProductCategory productcategory) {
		productcategoryservice.saveOrUpdate(productcategory);
		return productcategory;
	}

}
