package com.MedJacket.MedJ.Services;

import java.util.List;
import javax.management.AttributeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MedJacket.MedJ.Entity.Category;
import com.MedJacket.MedJ.Entity.Product;
import com.MedJacket.MedJ.Repository.CategoryRepository;
import com.MedJacket.MedJ.Repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Product createProduct(Long categoryId, Product product) throws AttributeNotFoundException{
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new AttributeNotFoundException("Category not found with id: " + categoryId));
		product.setCategory(category);
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Long productId, Product product) throws AttributeNotFoundException{
		Product existingProduct = productRepository.findById(productId)
				.orElseThrow(() -> new AttributeNotFoundException("Product not found with id: " + productId));
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		return productRepository.save(existingProduct);
	}

	@Override
	public void deleteProduct(Long productId) throws AttributeNotFoundException{
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new AttributeNotFoundException("Product not found with id: " + productId));
		productRepository.delete(product);
	}

	@Override
	public List<Product> getAllProductsByCategoryId(Long categoryId) throws AttributeNotFoundException{
		return productRepository.findByCategoryId(categoryId);
	}

	@Override
	public Product getProductById(Long productId) throws AttributeNotFoundException{
		return productRepository.findById(productId)
				.orElseThrow(() -> new AttributeNotFoundException("Product not found with id: " + productId));
	}
}
