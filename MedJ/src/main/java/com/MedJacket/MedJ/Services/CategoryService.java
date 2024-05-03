package com.MedJacket.MedJ.Services;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.stereotype.Service;

import com.MedJacket.MedJ.Entity.Category;

@Service
public interface CategoryService {
	Category createCategory(Category category) throws AttributeNotFoundException ;

	Category updateCategory (Long categoryId, Category category) throws AttributeNotFoundException ;

	void deleteCategory(Long categoryId) throws AttributeNotFoundException ;

	List<Category> getAllCategories() throws AttributeNotFoundException ;

	Category getCategoryById(Long categoryId) throws AttributeNotFoundException ;
}
