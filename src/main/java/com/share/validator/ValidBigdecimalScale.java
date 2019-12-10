package com.share.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数值类型校验有效数字
 *
 * @author guozhe
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {BigDecimalScaleValidator.class})
public @interface ValidBigdecimalScale {
    String message() default "有效数字位数不正确";

    /**
     * 最多允许的小数点后的有效数字位数
     * 如金额最多只允许保留2位有效数字，则此值为2
     */
    int value();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
