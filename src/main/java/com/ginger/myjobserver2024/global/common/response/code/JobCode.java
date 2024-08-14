package com.ginger.myjobserver2024.global.common.response.code;

import org.springframework.http.HttpStatus;

/**
 * 채용공고 도메인에서 쓰이는 상태코드
 */
public enum JobCode implements StatusCode {
    SUCCESS_CREATE_JOB(HttpStatus.OK, "2001", "채용공고 등록 성공"),
    SUCCESS_GET_JOB_DETAIL(HttpStatus.OK, "2002", "채용공고 상세 조회 성공"),
    SUCCESS_UPDATE_JOB(HttpStatus.OK, "2003", "채용공고 수정 성공"),

    JOB_NOT_FOUND(HttpStatus.NOT_FOUND, "4101", "해당 id 값의 채용공고를 찾을 수 없음"),
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
