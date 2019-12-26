package com.share.controller;

import com.share.ao.TransOutput;
import com.share.ao.UserAO;
import com.share.config.MethodValidationConfig;
import com.share.enums.PaySource;
import com.share.validator.ValidEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * @author guozhe
 * @date 2019-11-08
 */
@Slf4j
@Controller
@Validated
public class ValidationController {

    @ResponseBody
    @GetMapping(value = "/hello")
    public TransOutput hello(@RequestParam("name") @NotNull String name) {
        log.info("hello {}", name);
        return new TransOutput(TransOutput.SUCCESS_CODE, String.format("你好 %s", name));
    }

    /**
     * 演示spring的方法入参校验
     * 1、必须配置bean: MethodValidationPostProcessor
     * 2、类上必须加@Validated注解
     * 3、注解必须支持用在方法入参中，即：ElementType.PARAMETER
     *
     * @param paySource 资金渠道
     * @return 通用返回报文
     * @see MethodValidationConfig
     */
    @ResponseBody
    @GetMapping(value = "/pushToPaySource")
    public TransOutput pushToPaySource(@RequestParam("paySource") @ValidEnum(value = PaySource.class, message = "资金渠道不正确") @NotEmpty String paySource) {
        log.info("push bid to paySource {}", paySource);
        return new TransOutput(TransOutput.SUCCESS_CODE, String.format("have push bid to %s", paySource));
    }

    /**
     * 演示入参直接指定对应的枚举类型;
     * 定义接口时不建议使用这种方式，因为如果传错了值会报类型转换错误：
     * java.lang.IllegalArgumentException: No enum constant com.share.enums.PaySource.***
     * 接口定义可以使用上面的方法，使返回报文更友好，可控
     *
     * @param paySource 资金渠道
     * @return 通用返回报文
     */
    @ResponseBody
    @GetMapping(value = "/pushToPaySourceEnum")
    public TransOutput pushToPaySourceEnum(@RequestParam("paySource") @NotNull PaySource paySource) {
        log.info("push bid to paySource {}", paySource);
        return new TransOutput(TransOutput.SUCCESS_CODE, String.format("have push bid to %s", paySource));
    }

    @ResponseBody
    @PostMapping(value = "/receiveUser")
    public TransOutput receiveUser(@RequestBody @Valid UserAO user) {
        return new TransOutput(TransOutput.SUCCESS_CODE, String.format("receiveUser name=%s", user.getName()));
    }

}
