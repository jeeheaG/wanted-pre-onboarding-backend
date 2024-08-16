package com.ginger.myjobserver2024.domain;

import com.ginger.myjobserver2024.global.common.response.code.CommonCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * HealthCheck api 테스트 클래스
 */
@WebMvcTest(controllers = {HealthCheckController.class})
class HealthCheckControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser // 필요한 권한이 없는 경우
    void hello() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(CommonCode.OK.getCode()))
                .andExpect(jsonPath("$.message").value(CommonCode.OK.getMessage()))
                .andExpect(jsonPath("$.data").value("My job server is now running..."))
                .andDo(print())
                ;
    }
}