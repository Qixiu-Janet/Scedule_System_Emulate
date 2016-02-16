package com.scehdulesystem.service.impl;

import java.util.Set;

import com.scehdulesystem.domain.Product;
import com.scehdulesystem.domain.repository.InMemoryProductRepository;
import com.scehdulesystem.service.ProductService;


public class ProductServiceImpl implements ProductService{
	
	
	private InMemoryProductRepository productRepository=new InMemoryProductRepository() ;
	public Set<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}
	public Product getProductById(int productID) {
		return productRepository.getProductById(productID) ;
	}
	
    
}
