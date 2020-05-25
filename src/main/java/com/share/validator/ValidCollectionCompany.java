package com.share.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: fengpeng
 * @date: 2017/12/7  下午2:20
 * <p>
 * 校验
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CollectionCompanyValidator.class})
public @interface ValidCollectionCompany {
    String message() default "不正确的值，应该是\"AAAAA\", \"BBBBB\", \"CCCCC\", \"DDDDD\", \"EEEEE\" 其中之一";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
