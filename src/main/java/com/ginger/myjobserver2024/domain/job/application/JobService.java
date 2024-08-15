package com.ginger.myjobserver2024.domain.job.application;

import com.ginger.myjobserver2024.domain.job.domain.Job;
import com.ginger.myjobserver2024.domain.job.dto.JobModel;
import com.ginger.myjobserver2024.domain.job.dto.JobResponseDto;
import com.ginger.myjobserver2024.domain.job.repository.JobRepository;
import com.ginger.myjobserver2024.global.common.response.code.JobCode;
import com.ginger.myjobserver2024.global.common.response.exception.JobException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 채용공고 도메인의 비즈니스 로직을 담은 Service
 */
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

    /**
     * 고유 id 값으로 채용공고를 조회하는 메서드
     * @param jobId
     * @return
     */
    public Job getJobById(Long jobId) {
        Optional<Job> jobOp = jobRepository.findById(jobId);

        if (jobOp.isEmpty()) {
            throw new JobException(JobCode.JOB_NOT_FOUND);
        }
        else {
            return jobOp.get();
        }
    }


    /**
     * 채용공고 수정 메서드
     * @param jobId
     * @return
     */
    public Job updateJob(Long jobId, JobModel.UpdateJob model) {
        Job job = getJobById(jobId);

        job.updateJobInfo(model);

        return jobRepository.save(job);
    }

    /**
     * 채용공고 삭제 메서드
     * @param jobId
     */
    public void deleteJob(Long jobId) {
        jobRepository.delete(getJobById(jobId));
    }

    /**
     * 채용공고 목록 조회 메서드
     * @param pageable
     * @return
     */
    public JobResponseDto.GetJobList getJobList(Pageable pageable) {
        Slice<Job> jobs = jobRepository.findAllByOrderByCreatedAtDesc(pageable);

        return JobResponseDto.GetJobList.toDto(jobs);
    }

}
