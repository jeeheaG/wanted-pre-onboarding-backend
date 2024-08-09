package com.ginger.myjobserver2024.global.common.response.code;

import org.springframework.http.HttpStatus;

/**
 * 상태코드 enum 클래스들이 공통적으로 구현하는 인터페이스
 */
public interface StatusCode {
    HttpStatus getStatus();
    String getCode();
    String getMessage();
}
