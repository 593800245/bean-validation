package com.share.advance;

import com.alibaba.fastjson.JSON;
import com.share.ao.TransOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author guozhe
 * @date 2019-12-12
 */
@Slf4j
@ControllerAdvice("com.share.controller")
public class ControllerExceptionAdvance {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public TransOutput exceptionHandler(Exception e, HttpServletRequest request) {
//        log.info("HttpServletRequest={}", JSON.toJSONString(request));
        log.error("控制层接口抛出异常，URL={}，异常信息={}", request.getRequestURI(), e.getMessage(), e);
        return new TransOutput(TransOutput.FAILED_CODE, e.getMessage());
    }

}
