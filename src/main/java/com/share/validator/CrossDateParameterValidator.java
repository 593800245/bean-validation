package com.share.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 交叉验证两个日期，客户指定的较早的日期必须再较晚的日期之前
 * 此类是交叉验证多个字段的另一种方式，功能能够满足，但是是否优雅可取后续再确认
 *
 * @author guozhe
 * @date 2017/11/27
 */
public class CrossDateParameterValidator implements ConstraintValidator<ValidCrossDateParameter, CrossDateParameterValid> {

    @Override
    public void initialize(ValidCrossDateParameter constraintAnnotation) {
    }

    @Override
    public boolean isValid(CrossDateParameterValid value, ConstraintValidatorContext context) {
        if (null == value.getEarlierDate() || null == value.getLaterDate()) {
            return true;
        }
        return value.getEarlierDate().before(value.getLaterDate());
    }

}
