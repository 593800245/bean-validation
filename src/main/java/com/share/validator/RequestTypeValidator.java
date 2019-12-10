package com.share.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Created by zhangxiaojun on 2017/9/1.
 */
public class RequestTypeValidator implements ConstraintValidator<ValidRequestType,String> {


    /**
     *
     * 渠道大类: LEND - 个贷; JA - 借啊 ; MLM - 月光侠 ; YZ - 来点银子 ;
     * TREE_FINANCE - 大树金融 ; MAYI121 - 蚂蚁白领 ; RM - 任买;
     * 闪借 - SJ;闪银 - SY
     */
    private static final String[] ALL_STATUS = {"LEND", "JA", "MLM", "YZ", "TREE_FINANCE", "MAYI121",
            "RM", "SJ", "SY","FAN_CARD","FINUP_CAR"};

    @Override
    public void initialize(ValidRequestType constraintAnnotation) {
        // 不处理
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //如果是空，返回true，是因为如果null，则会有@NotNull进行提示
        if (value==null || 0==value.length()){
            return true;
        }
        return Arrays.asList(ALL_STATUS).contains(value);
    }
}
