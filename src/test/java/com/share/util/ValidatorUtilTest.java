package com.share.util;

import com.google.common.collect.Lists;
import com.share.ao.BorrowerAO;
import com.share.ao.RequestAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author guozhe
 * @date 2019-11-08
 */
@Slf4j
public class ValidatorUtilTest {

    @Test
    public void validate() {
        RequestAO requestAO = new RequestAO();
        requestAO.setRequestId("1");
        BorrowerAO borrower = new BorrowerAO();
        borrower.setGender("dddd");
        requestAO.setUser(borrower);
        requestAO.setTargetSources(Lists.newArrayList("hi"));
        Set<ConstraintViolation<RequestAO>> validate = ValidatorUtil.validate(requestAO);
//        log.info(ValidatorUtil.formatErrorMsg(validate));
    }


}