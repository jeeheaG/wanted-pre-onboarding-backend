package com.ginger.myjobserver2024.global.common.response.code;

import org.springframework.http.HttpStatus;

/**
 * 채용공고 도메인에서 쓰이는 상태코드
 */
public enum JobCode implements StatusCode {
    SUCCESS_CREATE_JOB(HttpStatus.OK, "2001", "채용공고 등록 성공"),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    JobCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }


    @Override
    public HttpStatus getStatus() {
        return httpStatus;
    }

    @Override
    public String getCode() {
        return StatusCodeDomain.COMMON.getDomainAsLabel() + code;
    }

    @Override
    public String getMessage() {
        return StatusCodeDomain.COMMON.getTitleAsLabel() + message;
    }
}
