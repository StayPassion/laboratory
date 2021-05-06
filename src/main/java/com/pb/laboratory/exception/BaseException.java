package com.pb.laboratory.exception;


public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -5790628735921441377L;
    protected String errorCode;

    public BaseException(String message) {
        super(message);
    }

    public static BaseException of(IErrorCode errorCode) {
        BaseException exception = new BaseException(errorCode.getMessage());
        exception.errorCode = errorCode.getErrorCode();
        return exception;
    }

    public static BaseException of(IErrorCode errorCode, String message) {
        BaseException exception = new BaseException(message);
        exception.errorCode = errorCode.getErrorCode();
        return exception;
    }

    public static BaseException of(BaseErrorCode errorCode) {
        return of(errorCode.of());
    }

    public static BaseException of(BaseErrorCode errorCode, String message) {
        BaseException exception = new BaseException(message);
        exception.errorCode = errorCode.getErrorCode();
        return exception;
    }

    public static BaseException of(IErrorCode errorCode, String message, Object... values) {
        return of(errorCode, replace(message, values));
    }

    public static BaseException of(String errorCode, String message, Object... values) {
        BaseException exception = new BaseException(replace(message, values));
        exception.errorCode = errorCode;
        return exception;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    private static String replace(String message, Object... values) {
        if (values != null) {
            Object[] var2 = values;
            int var3 = values.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                Object val = var2[var4];
                if (message.contains("{}")) {
                    message = message.replaceFirst("\\{}", val.toString());
                }
            }
        }

        return message;
    }
}
