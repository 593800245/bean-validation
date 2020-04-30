package com.share.advance;

import com.share.ao.TransOutput;
import com.share.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.io.BufferedReader;

/**
 * @author guozhe
 * @date 2019-12-12
 */
@Slf4j
@ControllerAdvice("com.share.controller")
public class ControllerExceptionAdvance {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public TransOutput exceptionHandler(ConstraintViolationException e, HttpServletRequest request) {
        String violationErrorMsg = ValidatorUtil.formatErrorMsg(e.getConstraintViolations());
        log.error("控制层接口抛出参数校验异常，URL={}， 异常信息={}", request.getRequestURI(), violationErrorMsg, e);
        return new TransOutput(TransOutput.FAILED_CODE, violationErrorMsg);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public TransOutput methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e, HttpServletRequest request) {
        String formatErrorMsg = ValidatorUtil.formatErrorMsg(e.getBindingResult().getFieldErrors());
        log.error("控制层接口抛出参数校验异常，URL={}，异常信息={}", request.getRequestURI(), formatErrorMsg, e);
        return new TransOutput(TransOutput.FAILED_CODE, formatErrorMsg);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public TransOutput methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException e, HttpServletRequest request) {
        String formatErrorMsg = e.getMessage();
        log.error("控制层接口抛出参数校验异常，URL={}，异常信息={}", request.getRequestURI(), formatErrorMsg, e);
        return new TransOutput(TransOutput.FAILED_CODE, formatErrorMsg);
    }

    private String getRequestString(HttpServletRequest request) {
        String requestString;
        if (HttpMethod.GET.matches(request.getMethod())) {
            requestString = request.getQueryString();
        } else {
            requestString = getRequestBody(request);
        }
        return requestString;
    }

    private String getRequestBody(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = request.getReader();
            while (reader.readLine() != null) {
                sb.append(reader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
