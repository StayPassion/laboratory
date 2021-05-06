package com.pb.laboratory.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Result<T> {
    private static final String successCode = "0000000000";
    public static final Result SUCCESS = new Result() {
        @Override
        public void setErrorCode(String errorCode) {
        }
        @Override
        public void setMessage(String message) {
        }
        @Override
        public void setData(Object data) {
        }
    };
    private String errorCode;
    private String message;
    private T data;

    private Result() {
        this.errorCode = "0000000000";
        this.message = "操作成功";
    }

    private Result(T data) {
        this.errorCode = "0000000000";
        this.message = "操作成功";
        this.data = data;
    }

    public Result(String errorCode, String message) {
        this(errorCode, message, null);
    }

    public Result(String errorCode, String message, T data) {
        this.errorCode = "0000000000";
        this.message = "操作成功";
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public static Result success() {
        return SUCCESS;
    }

    public static <T> Result<T> success(T data) {
        return new Result(data);
    }

    public static <T> Result<T> success(T data, String message) {
        return new Result("0000000000", message, data);
    }

    public static Result error(String errorCode, String message) {
        return new Result(errorCode, message);
    }

    public static Result error(IErrorCode error) {
        return new Result(error.getErrorCode(), error.getMessage());
    }

    public static Result of(BaseErrorCode baseErrorCode) {
        return new Result(baseErrorCode.getErrorCode(), baseErrorCode.getMessage());
    }

    @JsonIgnore
    public boolean isSuccess() {
        return "0000000000".equals(this.errorCode);
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setData(final T data) {
        this.data = data;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Result)) {
            return false;
        } else {
            Result<?> other = (Result)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$errorCode = this.getErrorCode();
                    Object other$errorCode = other.getErrorCode();
                    if (this$errorCode == null) {
                        if (other$errorCode == null) {
                            break label47;
                        }
                    } else if (this$errorCode.equals(other$errorCode)) {
                        break label47;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, message, data);
    }

    @Override
    public String toString() {
        return "Result(errorCode=" + this.getErrorCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
    }
}
