package com.share.validator;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.share.util.EnumTrait;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * 带数值的枚举值校验;
 * 校验数值是否在枚举中
 * 枚举必须实现EnumTrait接口
 *
 * @author guozhe
 * @date 2017/11/27
 */
public class NumberEnumValidator implements ConstraintValidator<ValidNumberEnum, Integer> {
    /**
     * 枚举Class
     */
    private Class<? extends Enum> enumClass;

    @Override
    public void initialize(ValidNumberEnum constraintAnnotation) {
        this.enumClass = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (null == value) {
            return true;
        }
        List<Integer> values = Lists.newArrayList();
        for (Enum resultStatus : enumClass.getEnumConstants()) {
            if (resultStatus instanceof EnumTrait) {
                values.add(((EnumTrait) resultStatus).getCode());
            }
        }
        if (values.contains(value)) {
            return true;
        }
        String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(String.format("%s%s%s%s", defaultConstraintMessageTemplate, "；正确的值包括：【", Joiner.on(",").join(values), "】"))
                .addConstraintViolation();
        return false;
    }

}
