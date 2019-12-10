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
 *
 * 校验回款主体
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CollectionCompanyValidator.class})
public @interface ValidCollectionCompany {
    String message() default "不正确的回款主体，应该是FINUP_GROUP - 凡普互金; BOHAI_TRUST - 渤海信托 ; BOHAI_TRUST_ZRB - 渤海信托真融宝 ; WAIMAO_TRUST - 外贸信托 ; BAIRONG_TRUST - 百融小贷 其中之一";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
