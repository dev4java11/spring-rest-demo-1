package com.casa.anotation.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casa.anotation.springmvc.domain.Office;

public interface OfficeRepository extends JpaRepository<Office, Integer> {

}
