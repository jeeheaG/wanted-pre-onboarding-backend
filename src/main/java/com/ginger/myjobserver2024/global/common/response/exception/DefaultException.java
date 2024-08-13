package com.ginger.myjobserver2024.global.common.response.exception;

import com.ginger.myjobserver2024.global.common.response.code.StatusCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DefaultException extends RuntimeException {
    private final StatusCode code;
}