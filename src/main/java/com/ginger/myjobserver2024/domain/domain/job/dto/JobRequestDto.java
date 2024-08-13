package com.ginger.myjobserver2024.domain.domain.job.dto;

import com.ginger.myjobserver2024.domain.domain.company.domain.Company;
import com.ginger.myjobserver2024.domain.domain.job.domain.Job;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * 채용공고 api dto 모음 클래스
 */
public class JobRequestDto {

    /**
     * 채용공고 생성 요청 body dto
     */
    @ToString
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateJob {

        @NotNull
        private Long jobId;

        @NotNull
        private Long companyId;

        @NotBlank
        private String country;

        @NotBlank
        private String region;

        @NotBlank
        private String position;

        private Integer reward;

        @NotBlank
        private String tech;

        private String content;

        public Job toEntity(Company company) {
            return Job.builder()
                    .id(this.jobId)
                    .company(company)
                    .country(this.country)
                    .region(this.region)
                    .position(this.position)
                    .reward(this.reward)
                    .content(this.content)
                    .tech(this.tech)
                    .build();
        }
    }
}
