package com.MedJacket.MedJ.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.MedJacket.MedJ.Entity.Category;
@EnableJpaRepositories
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
