package com.share.util;

import com.share.exception.AssetCommonException;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author guozhe
 * @date 2019-11-08
 */
@Slf4j
public class ValidatorUtil {

    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    private ValidatorUtil() {
        
    }

    public static <T> void validateWithException(T t) {
        Set<ConstraintViolation<T>> set = VALIDATOR.validate(t);
        if (set != null && !set.isEmpty()) {
            StringBuilder validateError = new StringBuilder();
            for (ConstraintViolation<T> error : set) {
                log.debug("error.getMessage():{}", error.getMessage());
                log.debug("error.getPropertyPath():{}", error.getPropertyPath());
                log.debug("error.getConstraintDescriptor():{}", error.getConstraintDescriptor());
                log.debug("error.getExecutableParameters():{}", error.getExecutableParameters());
                log.debug("error.getExecutableReturnValue():{}", error.getExecutableReturnValue());
                log.debug("error.getInvalidValue():{}", error.getInvalidValue());
                log.debug("error.getLeafBean():{}", error.getLeafBean());
                log.debug("error.getMessageTemplate():{}", error.getMessageTemplate());
                log.debug("error.getRootBeanClass():{}", error.getRootBeanClass());
                log.debug("error.getRootBean():{}", error.getRootBean());
                validateError.append(String.format("%s-%s ：[%s = %s] ;", "", error.getMessage(), error.getPropertyPath(), error.getInvalidValue()));
            }
            throw new AssetCommonException(validateError.toString());
        }
    }

    public static <T> Set<ConstraintViolation<T>> validate(T t) {
        return VALIDATOR.validate(t);
    }


}
