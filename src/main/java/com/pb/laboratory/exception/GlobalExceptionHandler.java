package com.pb.laboratory.exception;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.google.common.base.Joiner;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import java.nio.ByteBuffer;
import java.sql.SQLException;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final String notEmpty = "不能为空";

    public GlobalExceptionHandler() {
    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("Params valid exception={}\n{}", SessionHelper.getRequest().getRequestURI(), e.getMessage());
        return this.bindingResult(e.getBindingResult());
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> constraintViolationException(ConstraintViolationException e) {
        log.error("Params valid exception={}\n{}", SessionHelper.getRequest().getRequestURI(), e.getMessage());
        Result result = new Result(BaseErrorCode.INVALID_PARAM_ERROR.getErrorCode(), e.getMessage());
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({BindException.class})
    public ResponseEntity<Object> bindException(BindException e) {
        log.error("Params valid exception={}\n{}", SessionHelper.getRequest().getRequestURI(), e.getMessage());
        return this.bindingResult(e.getBindingResult());
    }

    private ResponseEntity<Object> bindingResult(BindingResult bindingResult) {
        List<FieldError> errors = bindingResult.getFieldErrors();
        StringBuilder messageBuilder = new StringBuilder();

        for (int i = 0; i < errors.size(); ++i) {
            FieldError error = (FieldError) errors.get(i);
            String message = Strings.isNotBlank(error.getDefaultMessage()) ? error.getDefaultMessage() : "不能为空";
            if ("不能为空".equals(message)) {
                messageBuilder.append(error.getField());
            }

            messageBuilder.append(message);
            if (i < errors.size() - 1) {
                messageBuilder.append(";");
            }
        }

        Result result = new Result(BaseErrorCode.INVALID_PARAM_ERROR.getErrorCode(), messageBuilder.toString());
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({SQLException.class})
    public ResponseEntity<Object> SQLException(SQLException e) {
        Result result = new Result(BaseErrorCode.SQL_EXCEPTION.getErrorCode(), BaseErrorCode.SQL_EXCEPTION.getMessage());
        log.error("sql  exception={}", e.getMessage(), e);
        return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({BaseException.class})
    public ResponseEntity<Object> baseException(BaseException e) {
        Result result = new Result(e.getErrorCode(), e.getMessage());
        log.error("internal server exception={}", e.getMessage(), e);
        return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<Object> methodNotSupportHandle(HttpRequestMethodNotSupportedException e) {
        Result result = new Result(BaseErrorCode.HTTP_REQUEST_FAILED.getErrorCode(), e.getMessage());
        log.error("HttpRequestMethodNotSupportedException exception={}", e.getMessage(), e);
        return new ResponseEntity(result, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler({TypeMismatchException.class})
    public ResponseEntity<Object> typeMismatchHandle(TypeMismatchException e) {
        Result result = new Result(BaseErrorCode.INVALID_PARAM_ERROR.getErrorCode(), BaseErrorCode.INVALID_PARAM_ERROR.getMessage() + e.getPropertyName() + "类型应该为" + e.getRequiredType());
        log.error("param type mismatch exception={}", e.getMessage(), e);
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<Object> httpMessageNotReadableHandle(HttpMessageNotReadableException e) {
        InvalidFormatException ife = (InvalidFormatException) e.getCause();
        Joiner joiner = Joiner.on(" ").skipNulls();
        String message = BaseErrorCode.INVALID_PARAM_ERROR.getMessage();
        if (null != ife) {
            message = joiner.join(message, "字段：", new Object[]{ife.getValue(), "正确类型:", ife.getTargetType()});
        }

        Result result = new Result(BaseErrorCode.INVALID_PARAM_ERROR.getErrorCode(), message);
        log.error("param type mismatch exception={}", e.getMessage(), e);
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<Object> noHandlerFoundException(NoHandlerFoundException e) {
        Result result = new Result(BaseErrorCode.API_NOT_EXIST_ERROR.getErrorCode(), BaseErrorCode.API_NOT_EXIST_ERROR.getMessage() + " 请求地址：" + e.getRequestURL());
        log.error("api not exist exception={}", e.getMessage(), e);
        return new ResponseEntity(result, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> globalHandle(Exception e) {
        Result result = Result.of(BaseErrorCode.SYS_INTERNAL_ERROR);
        log.error("exception={}", e.getMessage(), e);
        return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
