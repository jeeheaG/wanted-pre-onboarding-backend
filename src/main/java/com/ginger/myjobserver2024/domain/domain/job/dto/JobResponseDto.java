package com.ginger.myjobserver2024.domain.domain.job.dto;

import lombok.*;

import java.util.List;

public class JobResponseDto {


    @ToString
    @Getter
    @Builder
    public static class GetJobList {
        private Integer page;
        private Integer size;
        private List<SimpleJob> jobList;
    }

    @ToString
    @Getter
    @Builder
    public static class SimpleJob {
        private Long jobId;
        private Long companyId;
        private String country;
        private String region;
        private String position;
        private Integer reward;
        private String tech;
    }

    @ToString
    @Getter
    @Builder
    public static class DetailJob {
        private Long jobId;
        private Long companyId;
        private String country;
        private String region;
        private String position;
        private Integer reward;
        private String tech;
        private String content;
        private List<OtherJob> otherJobList;
    }


    @ToString
    @Getter
    @Builder
    public static class OtherJob {
        private Long jobId;
    }
}
