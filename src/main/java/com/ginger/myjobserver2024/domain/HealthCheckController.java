package com.ginger.myjobserver2024.domain;

import com.ginger.myjobserver2024.global.common.response.CommonResponse;
import com.ginger.myjobserver2024.global.common.response.code.CommonCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<Object> hello() {
        log.info("[API] GET /");
        return ResponseEntity.ok()
                .body(CommonResponse.toResponse(CommonCode.OK, "My job server is now running..."));
    }

}
