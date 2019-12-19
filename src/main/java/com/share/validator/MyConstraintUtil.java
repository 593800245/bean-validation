package com.share.validator;

import com.google.common.base.Joiner;

import javax.validation.ConstraintValidatorContext;

/**
 * @author guozhe
 * @date 2019-12-19
 */
public class MyConstraintUtil {

    private MyConstraintUtil() {

    }

    /**
     * 修改约束的错误信息
     * 在原错误信息上增加用户自定义的扩展错误信息
     *
     * @param context          约束上下文
     * @param extendFeeMessage 扩展错误信息
     */
    public static void changeConstraintMessageTemplate(ConstraintValidatorContext context, String extendFeeMessage) {
        String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(Joiner.on(";").join(defaultConstraintMessageTemplate, extendFeeMessage)).addConstraintViolation();
    }
}
