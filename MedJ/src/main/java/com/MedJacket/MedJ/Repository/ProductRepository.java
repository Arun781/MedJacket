package com.MedJacket.MedJ.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.MedJacket.MedJ.Entity.Product;
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Long> {
	 List<Product> findByCategoryId(Long categoryId);
}
