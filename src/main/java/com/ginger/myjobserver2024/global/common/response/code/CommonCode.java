package com.ginger.myjobserver2024.global.common.response.code;

import org.springframework.http.HttpStatus;

/**
 * 도메인에 상관없이 일반적으로 쓰이는 상태코드
 */
public enum CommonCode implements StatusCode {
    OK(HttpStatus.OK, "2000", "정상 처리"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "5000", "서버 내부 오류"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "4000", "잘못된 요청"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "4100", "인증되지 않음"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "4300", "권한 부족"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "4400", "요청 리소스를 찾을 수 없음"),

    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    CommonCode(HttpStatus httpStatus, String code, String message) {
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
