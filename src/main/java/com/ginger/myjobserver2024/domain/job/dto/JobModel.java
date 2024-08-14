package com.ginger.myjobserver2024.domain.job.dto;

import lombok.*;

public class JobModel {

    /**
     * 채용공고 수정 model
     */
    @ToString
    @Getter
    @Builder
    public static class UpdateJob {

        private String country;

        private String region;

        private String position;

        private Integer reward;

        private String tech;

        private String content;

    }
}
