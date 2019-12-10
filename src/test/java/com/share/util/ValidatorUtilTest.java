package com.share.util;

import com.google.common.collect.Lists;
import com.share.ao.BorrowerAO;
import com.share.ao.RequestAO;
import org.junit.Test;

/**
 * @author guozhe
 * @date 2019-11-08
 */
public class ValidatorUtilTest {

    @Test
    public void validate() {
        RequestAO requestAO = new RequestAO();
        requestAO.setRequestId("1");
        BorrowerAO borrower = new BorrowerAO();
        borrower.setGender("dddd");
        requestAO.setUser(borrower);
        requestAO.setTargetSources(Lists.newArrayList("hi"));
        ValidatorUtil.validate(requestAO);
    }

}