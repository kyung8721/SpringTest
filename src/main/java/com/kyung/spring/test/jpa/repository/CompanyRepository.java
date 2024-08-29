package com.kyung.spring.test.jpa.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kyung.spring.test.jpa.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}

