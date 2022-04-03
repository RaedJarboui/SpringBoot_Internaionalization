package com.translate.service;

import java.util.List;

import com.translate.entity.Product;

public interface ProductService {
	public List<Product> getAllProducts();

	public Product saveProduct(Product p);

}
