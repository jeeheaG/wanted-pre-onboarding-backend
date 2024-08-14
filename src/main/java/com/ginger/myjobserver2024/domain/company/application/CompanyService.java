package com.ginger.myjobserver2024.domain.company.application;

import com.ginger.myjobserver2024.domain.company.repository.CompanyRepository;
import com.ginger.myjobserver2024.domain.company.domain.Company;
import com.ginger.myjobserver2024.global.common.response.code.CommonCode;
import com.ginger.myjobserver2024.global.common.response.exception.CompanyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 회사 도메인의 비즈니스 로직을 담은 Service
 */
@Slf4j
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    /**
     * 고유 id 값으로 회사를 조회하는 메서드
     * @param id
     * @return
     */
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
