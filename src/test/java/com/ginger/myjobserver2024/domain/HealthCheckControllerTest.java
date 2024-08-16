package com.ginger.myjobserver2024.domain;

import com.ginger.myjobserver2024.global.common.response.code.CommonCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * HealthCheck api 테스트 클래스
 */
@WebMvcTest(controllers = {HealthCheckController.class})
@DisplayName("[Health Check] 컨트롤러 단위 테스트")
class HealthCheckControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser // 필요한 권한이 없는 경우
    @DisplayName("Success hello")
    void hello() throws Exception {
        //given
        //when
        MockHttpServletRequestBuilder requestGet = get("/")
                .with(csrf().asHeader());

        //then
        mockMvc.perform(requestGet)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(CommonCode.OK.getCode()))
                .andExpect(jsonPath("$.message").value(CommonCode.OK.getMessage()))
                .andExpect(jsonPath("$.data").value("My job server is now running..."))
                .andDo(print())
        ;
    }
}