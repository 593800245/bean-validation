package com.share.validator;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

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
        List<String> values = Lists.newArrayList();
        for (Enum resultStatus : enumClass.getEnumConstants()) {
            values.add(resultStatus.name());
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
