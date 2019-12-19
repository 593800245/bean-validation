package com.share.validator;

import com.google.common.base.Joiner;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 枚举值校验
 *
 * @author guozhe
 * @date 2017/11/27
 */
public class EnumValidator implements ConstraintValidator<ValidEnum, String> {
    /**
     * 枚举Class
     */
    private Class<? extends Enum> enumClass;

    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        this.enumClass = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (null == value) {
            return true;
        }
        Enum[] enumConstants = enumClass.getEnumConstants();
        if (Arrays.stream(enumConstants).map(Enum::name).collect(Collectors.toSet()).contains(value)) {
            return true;
        }
        MyConstraintUtil.changeConstraintMessageTemplate(context, "正确的值包括：【" + Joiner.on(",").join(enumConstants) + "】");
        return false;
    }

}
