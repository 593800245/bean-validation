package com.share.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 枚举值校验
 *故意去掉 ElementType.PARAMETER ，演示此注解用在方法入参中时不会生效
 * @author guozhe
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EnumValidator.class})
public @interface ValidEnum {
    String message() default "值不正确";

    Class<? extends Enum> value();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
