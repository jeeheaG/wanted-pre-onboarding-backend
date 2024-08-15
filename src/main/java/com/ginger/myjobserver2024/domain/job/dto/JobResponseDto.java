package com.ginger.myjobserver2024.domain.job.dto;

import com.ginger.myjobserver2024.domain.job.domain.Job;
import lombok.*;
import org.springframework.data.domain.Slice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 채용공고 api 응답 dto 모음 클래스
 */
public class JobResponseDto {


    /**
     * 채용공고 조회 응답 dto
     */
    @ToString
    @Getter
    @Builder
    public static class GetJobList {
        private Integer page;
        private Integer size;
        private List<SimpleJob> jobList;

        /**
         * 채용공고 목록으로 해당 dto 클래스를 만들어주는 메서드
         * @param jobs
         * @return
         */
        public static GetJobList toDto(Slice<Job> jobs) {
            return GetJobList.builder()
                    .page(jobs.getNumber())
                    .size(jobs.getSize())
                    .jobList(SimpleJob.toDtos(jobs))
                    .build();
        }
    }

    /**
     * 채용공고 간략한 조회 클래스
     */
    @ToString
    @Getter
    @Builder
    public static class SimpleJob {
        private Long jobId;
        private Long companyId;
        private String companyName;
        private String country;
        private String region;
        private String position;
        private Integer reward;
        private String tech;

        /**
         * 엔티티 객체로 해당 dto 클래스를 만들어주는 메서드
         * @param job
         * @return
         */
        private static SimpleJob toDto(Job job) {
            return SimpleJob.builder()
                    .jobId(job.getId())
                    .companyId(job.getCompany().getId())
                    .companyName(job.getCompany().getName())
                    .country(job.getCountry())
                    .region(job.getRegion())
                    .position(job.getPosition())
                    .tech(job.getTech())
                    .build();
        }

        /**
         * dto 클래스 리스트를 만들어주는 메서드
         * @param jobList
         * @return
         */
        public static List<SimpleJob> toDtos(Slice<Job> jobList) {
            return jobList.stream()
                    .map(SimpleJob::toDto)
                    .collect(Collectors.toList());
        }

    }

    /**
     * 채용공고 자세한 조회 클래스
     */
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

        /**
         * Job 객체를 받아 해당 DTO클래스로 만들어 반환해주는 메서드
         * @param job
         * @return
         */
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

    /**
     * 채용공고 상세 조회 내 다른 채용공고 데이터 클래스
     */
    @ToString
    @Getter
    @Builder
    public static class OtherJob {
        private Long jobId;
    }
}
