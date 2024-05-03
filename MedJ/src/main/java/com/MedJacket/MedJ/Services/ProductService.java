package com.MedJacket.MedJ.Services;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.stereotype.Service;

import com.MedJacket.MedJ.Entity.Product;

@Service
public interface ProductService {
	Product createProduct(Long categoryId,Product product) throws AttributeNotFoundException;

	Product updateProduct(Long productId, Product product) throws AttributeNotFoundException;

	void deleteProduct(Long productId) throws AttributeNotFoundException;

	List<Product> getAllProductsByCategoryId(Long categoryId) throws AttributeNotFoundException;

	Product getProductById(Long productId) throws AttributeNotFoundException;
}
