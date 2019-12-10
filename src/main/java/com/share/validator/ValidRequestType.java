package com.share.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhangxiaojun on 2017/9/1.
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {RequestTypeValidator.class})
public @interface ValidRequestType {
    String message() default "不正确的渠道，应该是 LEND - 个贷; JA - 借啊 ; MLM - 月光侠 ; YZ - 来点银子 ; TREE_FINANCE - 大树金融 ; MAYI121 - 蚂蚁白领 ; RM - 任买 其中之一";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
