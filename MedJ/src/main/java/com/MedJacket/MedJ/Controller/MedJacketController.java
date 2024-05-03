package com.MedJacket.MedJ.Controller;

import java.util.List;
import javax.management.AttributeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.MedJacket.MedJ.Entity.Category;
import com.MedJacket.MedJ.Entity.Product;
import com.MedJacket.MedJ.Services.CategoryService;
import com.MedJacket.MedJ.Services.ProductService;

@RestController
@RequestMapping("/api/categories")
public class MedJacketController {
	@Autowired
	private CategoryService categoryService;

	// Create a new category
	@PostMapping
	public ResponseEntity<Category> createCategory(@Validated @RequestBody Category category) {
		Category savedCategory = categoryService.createCategory(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
	}

	// Get all categories
	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> categories = categoryService.getAllCategories();
		return ResponseEntity.ok(categories);
	}

	// Get category by ID
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long id) throws AttributeNotFoundException {
		Category category = categoryService.getCategoryById(id);
		if (category != null) {
			return ResponseEntity.ok(category);
		}
		return ResponseEntity.notFound().build();
	}

	// Update category by ID
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable Long id, @Validated @RequestBody Category category) throws AttributeNotFoundException {
		Category updatedCategory = categoryService.updateCategory(id, category);
		if (updatedCategory != null) {
			return ResponseEntity.ok(updatedCategory);
		}
		return ResponseEntity.notFound().build();
	}

	// Delete category by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long id) throws AttributeNotFoundException {
		categoryService.deleteCategory(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	@Autowired
    private ProductService productService;

    // Create a new product
    @PostMapping
    public ResponseEntity<Product> createProduct(@Validated @RequestBody Product product,Long id) throws AttributeNotFoundException {
        Product savedProduct = productService.createProduct(id, product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    // Get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() throws AttributeNotFoundException {
        List<Product> products = productService.getAllProductsByCategoryId(null);
        return ResponseEntity.ok(products);
    }

    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws AttributeNotFoundException {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    // Update product by ID
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Validated @RequestBody Product product) throws AttributeNotFoundException {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) throws AttributeNotFoundException {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
