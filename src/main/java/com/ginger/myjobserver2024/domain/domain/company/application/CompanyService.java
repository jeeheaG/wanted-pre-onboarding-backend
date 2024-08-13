package com.ginger.myjobserver2024.domain.domain.company.application;

import com.ginger.myjobserver2024.domain.domain.company.domain.Company;
import com.ginger.myjobserver2024.domain.domain.company.repository.CompanyRepository;
import com.ginger.myjobserver2024.global.common.response.code.CommonCode;
import com.ginger.myjobserver2024.global.common.response.exception.CompanyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company findCompanyById(Long id) {
        Optional<Company> companyOp = companyRepository.findById(id);

        if (companyOp.isEmpty()) {
            throw new CompanyException(CommonCode.BAD_REQUEST);
        }
        else {
            return companyOp.get();
        }
    }
}
