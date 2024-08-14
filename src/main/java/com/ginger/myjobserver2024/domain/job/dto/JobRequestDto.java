package com.ginger.myjobserver2024.domain.job.dto;

import com.ginger.myjobserver2024.domain.company.domain.Company;
import com.ginger.myjobserver2024.domain.job.domain.Job;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * 채용공고 api 요청 dto 모음 클래스
 */
public class JobRequestDto {

    /**
     * 채용공고 생성 요청 dto
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

        /**
         * Job 객체를 받아 해당 DTO클래스로 만들어 반환해주는 메서드
         * @param company
         * @return
         */
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

    /**
     * 채용공고 수정 요청 dto
     */
    @ToString
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateJob {

        private String country;

        private String region;

        private String position;

        private Integer reward;

        private String tech;

        private String content;

        public JobModel.UpdateJob toModel() {
            return JobModel.UpdateJob.builder()
                    .country(this.country)
                    .region(this.region)
                    .position(this.position)
                    .reward(this.reward)
                    .tech(this.tech)
                    .content(this.content)
                    .build();
        }
    }
}
