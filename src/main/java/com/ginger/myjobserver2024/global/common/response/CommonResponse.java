package com.ginger.myjobserver2024.global.common.response;

import com.ginger.myjobserver2024.global.common.response.code.StatusCode;
import com.ginger.myjobserver2024.global.config.ZonedTimeUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


/**
 * 응답 데이터를 담는 클래스
 */
@ToString
@Getter
@Builder
@RequiredArgsConstructor
public class CommonResponse {
    private final String timestamp = ZonedTimeUtil.getZonedTimestamp();
    private final String code;
    private final String message;
    private final Object data;


    public CommonResponse toResponse(StatusCode statusCode) {
        return CommonResponse.builder()
                .code(statusCode.getCode())
                .message(statusCode.getMessage())
                .build();
    }

    public CommonResponse toResponse(StatusCode statusCode, Object data) {
        return CommonResponse.builder()
                .code(statusCode.getCode())
                .message(statusCode.getMessage())
                .data(data)
                .build();
    }

    public CommonResponse toResponse(StatusCode statusCode, String message) {
        return CommonResponse.builder()
                .code(statusCode.getCode())
                .message(message)
                .build();

    }
}
