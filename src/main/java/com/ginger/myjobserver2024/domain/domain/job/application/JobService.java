package com.ginger.myjobserver2024.domain.domain.job.application;

import com.ginger.myjobserver2024.domain.domain.job.domain.Job;
import com.ginger.myjobserver2024.domain.domain.job.repository.JobRepository;
import com.ginger.myjobserver2024.global.common.response.code.JobCode;
import com.ginger.myjobserver2024.global.common.response.exception.JobException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void saveJob(Job job) {
        jobRepository.save(job);
    }


}
