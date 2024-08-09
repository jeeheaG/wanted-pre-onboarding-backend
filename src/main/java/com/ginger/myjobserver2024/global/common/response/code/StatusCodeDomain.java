package com.ginger.myjobserver2024.global.common.response.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 상태코드 도메인들을 일관적으로 사용하기 위해 enum 으로 관리하는 클래스
 */
@Getter
@RequiredArgsConstructor
public enum StatusCodeDomain {
    COMMON("COMMON", "공통"),
    ;

    private final String domain;
    private final String title;

    public String getDomainAsLabel() {
        return this.domain + "-";
    }

    public String getTitleAsLabel() {
        return "[" + this.title + "]";
    }
}

