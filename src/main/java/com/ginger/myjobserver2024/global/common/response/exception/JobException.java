package com.ginger.myjobserver2024.global.common.response.exception;

import com.ginger.myjobserver2024.global.common.response.code.StatusCode;

public class JobException extends DefaultException{
    public JobException(StatusCode code) {
        super(code);
    }
}
