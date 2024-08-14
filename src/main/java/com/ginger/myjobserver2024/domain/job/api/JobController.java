package com.ginger.myjobserver2024.domain.job.api;

import com.ginger.myjobserver2024.domain.company.application.CompanyService;
import com.ginger.myjobserver2024.domain.company.domain.Company;
import com.ginger.myjobserver2024.domain.job.application.JobService;
import com.ginger.myjobserver2024.domain.job.domain.Job;
import com.ginger.myjobserver2024.domain.job.dto.JobRequestDto;
import com.ginger.myjobserver2024.domain.job.dto.JobResponseDto;
import com.ginger.myjobserver2024.global.common.response.CommonResponse;
import com.ginger.myjobserver2024.global.common.response.code.JobCode;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 채용공고관련 api 컨트롤러
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    private final JobService jobService;
    private final CompanyService companyService;

    public JobController(JobService jobService, CompanyService companyService) {
        this.jobService = jobService;
        this.companyService = companyService;
    }

    /**
     * 채용공고 등록 api
     * @param requestDto
     * @return
     */
    @PostMapping
    public ResponseEntity<Object> createJob(@RequestBody @Valid JobRequestDto.CreateJob requestDto) {
        log.info("[API] POST /jobs");

        Company company = companyService.findCompanyById(requestDto.getCompanyId());

        jobService.saveJob(requestDto.toEntity(company)); // TODO : Job 도메인에 createJob 이런식으로 옮기기

        return ResponseEntity.ok(CommonResponse.toResponse(JobCode.SUCCESS_CREATE_JOB));
    }

    /**
     * 채용공고 상세 조회 api
     * @param jobId
     * @return
     */
    @GetMapping("/{jobId}")
    public ResponseEntity<Object> getJobDetail(@PathVariable Long jobId) {
        log.info("[API] GET /jobs/{}", jobId);

        Job job = jobService.getJobById(jobId);

        return ResponseEntity.ok(CommonResponse.toResponse(JobCode.SUCCESS_GET_JOB_DETAIL, JobResponseDto.DetailJob.toDto(job)));
    }

    /**
     * 채용공고 수정 api
     * @param jobId
     * @param requestDto
     * @return
     */
    @PatchMapping("/{jobId}")
    public ResponseEntity<Object> updateJob(@PathVariable Long jobId, @RequestBody @Valid JobRequestDto.UpdateJob requestDto) {
        log.info("[API] PATCH /jobs/{}", jobId);

        Job job = jobService.updateJob(jobId, requestDto.toModel());

        return ResponseEntity.ok(CommonResponse.toResponse(JobCode.SUCCESS_UPDATE_JOB, JobResponseDto.DetailJob.toDto(job)));
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteJob(@PathVariable Long jobId) {
        log.info("[API] DELETE /jobs/{}", jobId);

        jobService.deleteJob(jobId);

        return ResponseEntity.ok(CommonResponse.toResponse(JobCode.SUCCESS_DELETE_JOB));
    }

}
