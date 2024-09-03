package com.ginger.myjobserver2024.domain.job.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ginger.myjobserver2024.domain.company.application.CompanyService;
import com.ginger.myjobserver2024.domain.company.domain.Company;
import com.ginger.myjobserver2024.domain.job.application.JobService;
import com.ginger.myjobserver2024.domain.job.domain.Job;
import com.ginger.myjobserver2024.domain.job.dto.JobRequestDto;
import com.ginger.myjobserver2024.global.common.response.code.JobCode;
import com.ginger.myjobserver2024.global.common.response.code.StatusCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 채용공고 api 의 컨트롤러단 메서드 테스트 클래스
 */
@WithMockUser // Spring Security 처리 : 모두 권한이 필요하지 않은 요청들
@DisplayName("[채용공고] 컨트롤러 단위 테스트")
@WebMvcTest(controllers = {JobController.class})
class JobControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JobService jobService;
    @MockBean
    private CompanyService companyService;

    private Company company;
    private Job job;

    @Nested
    @DisplayName("채용공고 생성")
    class CreateJob {

        @Nested
        @DisplayName("Success case")
        class SuccessCase {

            @Test
            @DisplayName("모든 필드 포함 경우")
            void createJob() throws Exception {
                //given
                Company company = Company.builder().id(1L).name("회사A").build();
                Job job = Job.builder()
                        .id(1L)
                        .company(company)
                        .country("한국")
                        .region("판교")
                        .position("백엔드")
                        .reward(100)
                        .tech("spring boot")
                        .content("백엔드 spring 개발자 구인합니다.")
                        .build();
                JobRequestDto.CreateJob dto = JobRequestDto.CreateJob.builder()
                        .jobId(job.getId())
                        .companyId(job.getCompany().getId())
                        .country(job.getCountry())
                        .region(job.getRegion())
                        .position(job.getPosition())
                        .reward(job.getReward())
                        .tech(job.getTech())
                        .content(job.getContent())
                        .build();

                //when
                StatusCode code = JobCode.SUCCESS_CREATE_JOB;

                MockHttpServletRequestBuilder requestPost = post("/api/v1/jobs")
                        .content(new ObjectMapper().writeValueAsString(dto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .with(csrf().asHeader());

                //then
                ResultActions resultActions = mockMvc.perform(requestPost);

                resultActions
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.code").value(code.getCode()))
                        .andExpect(jsonPath("$.message").value(code.getMessage()))
                        .andDo(print())
                ;
            }
        }
    }


    @Test
    void getJobDetail() {
    }

    @Test
    void updateJob() {
    }

    @Test
    void deleteJob() {
    }
}