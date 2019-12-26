package com.share.util;

import com.share.exception.MyCommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * @author guozhe
 * @date 2019-11-08
 */
@Slf4j
public class ValidatorUtil {

    public static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

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
                validateError.append(formatErrorMsg(error.getPropertyPath().toString(), error.getMessage(), error.getInvalidValue()));
            }
            throw new MyCommonException(validateError.toString());
        }
    }

    public static <T> Set<ConstraintViolation<T>> validate(T t) {
        return VALIDATOR.validate(t);
    }

    public static <T> Set<ConstraintViolation<T>> validate(T t, Class group) {
        if (null != group) {
            return VALIDATOR.validate(t, group);
        }
        return validate(t);
    }

    public static String formatErrorMsg(Set<ConstraintViolation<?>> set) {
        StringBuilder validateError = new StringBuilder();
        for (ConstraintViolation<?> error : set) {
            validateError.append(formatErrorMsg(error.getPropertyPath().toString(), error.getMessageTemplate(), error.getInvalidValue()));
        }
        return validateError.toString();
    }

    public static String formatErrorMsg(List<FieldError> allErrors) {
        StringBuilder validateError = new StringBuilder();
        for (FieldError objectError : allErrors) {
            validateError.append(formatErrorMsg(objectError.getField(), objectError.getDefaultMessage(), objectError.getRejectedValue()));
        }
        return validateError.toString();
    }

    private static String formatErrorMsg(String fieldName, String message, Object invalidValue) {
        return String.format("[%s%s,invalidValue=%s] ;", fieldName, message, invalidValue);
    }

}
