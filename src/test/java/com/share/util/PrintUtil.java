package com.share.util;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author guozhe
 * @date 2019-12-04
 */
public class PrintUtil {

    /**
     * 打印违反约束后的描述信息
     *
     * @param constraintViolationSet 违反约束后的
     */
    public static <T> void print(Set<ConstraintViolation<T>> constraintViolationSet) {
        for (ConstraintViolation<T> violation : constraintViolationSet) {
            System.err.println(String.format("validate result, constraint = %s, filed = %s, invalidValue = %s, message = %s",
                    violation.getConstraintDescriptor().getAnnotation().annotationType(), violation.getPropertyPath(), violation.getInvalidValue(), violation.getMessage()));
        }
    }

    /**
     * 打印违反约束后的描述信息
     *
     * @param constraintViolationSet 违反约束后的
     */
    public static <T> void print(Set<ConstraintViolation<T>> constraintViolationSet, String prefix) {
        for (ConstraintViolation<T> violation : constraintViolationSet) {
            System.err.println(String.format("prefix = %s, filed = %s, invalidValue = %s, message = %s",
                    prefix, violation.getPropertyPath(), violation.getInvalidValue(), violation.getMessage()));
        }
    }

}
