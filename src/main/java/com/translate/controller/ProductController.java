/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.translate.entity.Product;
import com.translate.service.ProductService;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping
	@ResponseBody
	public List<Product> getAllProducts() {

		return productService.getAllProducts();
	}

	@PostMapping
	@ResponseBody
	public Product saveProduct(@RequestBody Product p) {

		return productService.saveProduct(p);
	}

}
