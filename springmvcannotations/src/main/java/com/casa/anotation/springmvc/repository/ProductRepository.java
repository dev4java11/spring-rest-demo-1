package com.casa.anotation.springmvc.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.casa.anotation.springmvc.domain.Product;
import com.casa.anotation.springmvc.domain.Productline;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, String> {

	List<Product> findAll();
	
	List<Product> findByProductline(Productline productline);
	
	@Procedure(name ="Product.spgenerateProductCode")
	String generateProductCode(@Param("scaleProduct") int scale);
	
}
