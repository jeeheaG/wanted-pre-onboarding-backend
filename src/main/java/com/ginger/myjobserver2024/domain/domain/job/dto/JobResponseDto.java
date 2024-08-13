package com.ginger.myjobserver2024.domain.domain.job.dto;

import com.ginger.myjobserver2024.domain.domain.job.domain.Job;
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

        public static DetailJob toDto(Job job) { // List<OtherJob> otherJobList
            return DetailJob.builder()
                    .jobId(job.getId())
                    .companyId(job.getCompany().getId())
                    .country(job.getCountry())
                    .region(job.getRegion())
                    .position(job.getPosition())
                    .reward(job.getReward())
                    .tech(job.getTech())
                    .content(job.getContent())
                    // .otherJobList(otherJobList)
                    .build();
        }
    }


    @ToString
    @Getter
    @Builder
    public static class OtherJob {
        private Long jobId;
    }
}
