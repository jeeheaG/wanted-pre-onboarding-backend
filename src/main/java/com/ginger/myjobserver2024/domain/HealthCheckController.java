package com.ginger.myjobserver2024.domain;

import com.ginger.myjobserver2024.global.common.response.CommonResponse;
import com.ginger.myjobserver2024.global.common.response.code.CommonCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 서버가 정상동작 중인지 확인하는 요청을 가진 컨트롤러
 */
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
