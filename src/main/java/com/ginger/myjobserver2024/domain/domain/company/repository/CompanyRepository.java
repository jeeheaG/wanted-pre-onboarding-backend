package com.ginger.myjobserver2024.domain.domain.company.repository;

import com.ginger.myjobserver2024.domain.domain.company.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
