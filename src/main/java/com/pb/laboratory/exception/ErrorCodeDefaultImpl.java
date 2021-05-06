package com.pb.laboratory.exception;

public class ErrorCodeDefaultImpl implements IErrorCode {
    private String errorCode;
    private String message;

    public ErrorCodeDefaultImpl(String errorCode, String message) {
        this.errorCode =  errorCode;
        this.message = message;
    }

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
