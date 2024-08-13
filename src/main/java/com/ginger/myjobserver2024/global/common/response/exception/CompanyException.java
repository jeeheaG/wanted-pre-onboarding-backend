package com.ginger.myjobserver2024.global.common.response.exception;

import com.ginger.myjobserver2024.global.common.response.code.StatusCode;

public class CompanyException extends DefaultException{
    public CompanyException(StatusCode code) {
        super(code);
    }
}
