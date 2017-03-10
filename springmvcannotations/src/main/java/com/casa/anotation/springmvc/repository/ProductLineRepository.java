package com.casa.anotation.springmvc.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casa.anotation.springmvc.domain.Productline;

@Repository("productLineRepository")
public interface ProductLineRepository extends JpaRepository<Productline, String> {
	
	Productline findByproductLine(String productLine);

}
