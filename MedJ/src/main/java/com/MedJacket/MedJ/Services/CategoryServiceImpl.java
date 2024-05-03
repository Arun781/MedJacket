package com.MedJacket.MedJ.Services;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedJacket.MedJ.Entity.Category;
import com.MedJacket.MedJ.Repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService {

	 @Autowired
	    private CategoryRepository categoryRepository;

	    @Override
	    public Category createCategory(Category category) {
	        return categoryRepository.save(category);
	    }

	    @Override
	    public Category updateCategory(Long categoryId, Category category) throws AttributeNotFoundException {
	        Category existingCategory = categoryRepository.findById(categoryId)
	        		.orElseThrow(() -> new AttributeNotFoundException(""));
	        existingCategory.setName(category.getName());
	        existingCategory.setDescription(category.getDescription());
	        return categoryRepository.save(existingCategory);
	    }

	    @Override
	    public void deleteCategory(Long categoryId) throws AttributeNotFoundException{
	        Category category = categoryRepository.findById(categoryId)
	                .orElseThrow(() -> new AttributeNotFoundException("Category not found with id: " + categoryId));
	        categoryRepository.delete(category);
	    }
	    @Override
	    public List<Category> getAllCategories() {
	        return categoryRepository.findAll();
	    }
	    @Override
	    public Category getCategoryById(Long categoryId) throws AttributeNotFoundException{
	        return categoryRepository.findById(categoryId)
	                .orElseThrow(() -> new AttributeNotFoundException("Category not found with id: " + categoryId));
	    }
}
