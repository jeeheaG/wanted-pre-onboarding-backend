package com.ginger.myjobserver2024.domain.domain.job.dto;

import lombok.*;

public class JobRequestDto {

    @ToString
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createJob {
        private Long companyId;
        private String position;
        private String content;
        private String tech;
    }
}
