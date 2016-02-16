package com.scehdulesystem.service;

import java.util.Set;

import com.scehdulesystem.domain.Product;

public interface ProductService {
	public Product getProductById(int productID);
	public Set<Product> getAllProducts();
	
}
