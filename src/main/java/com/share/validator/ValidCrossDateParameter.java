package com.share.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 交叉参数校验-比较两个日期的大小
 * 此类是交叉验证多个字段的另一种方式，功能能够满足，但是是否优雅可取后续再确认
 *
 * @author guozhe
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CrossDateParameterValidator.class})
public @interface ValidCrossDateParameter {

    /**
     * 没有默认值，客户使用时必须自己定义message信息
     *
     * @return 错误信息
     */
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
