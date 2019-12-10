package com.share.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * @author: fengpeng
 * @date: 2017/12/11  下午7:48
 *
 * 校验回款主体方法
 */
public class CollectionCompanyValidator implements ConstraintValidator<ValidCollectionCompany,String> {
    /**
     * 所有的回款主体
     */
    private static final String[] ALL_STATUS = {"FINUP_GROUP", "BOHAI_TRUST", "BOHAI_TRUST_ZRB",
            "WAIMAO_TRUST", "BAIRONG_TRUST"};

    @Override
    public void initialize(ValidCollectionCompany validCollectionCompany) {
        // 不处理
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        //如果是空，返回true，因为回款主体可以为空
        if (value==null || 0==value.length()){
            return true;
        }
        return Arrays.asList(ALL_STATUS).contains(value);
    }
}
