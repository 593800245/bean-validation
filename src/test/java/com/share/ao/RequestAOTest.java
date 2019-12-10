package com.share.ao;

import com.share.util.PrintUtil;
import com.share.util.ValidatorUtil;
import org.junit.Test;

/**
 * @author guozhe
 * @date 2019-12-04
 */
public class RequestAOTest {

    @Test
    public void test() {
        RequestAO requestAO = new RequestAO();
//        requestAO.setEmail("假的邮箱");
        requestAO.setEmail("");
        requestAO.setFullName("");
        PrintUtil.print(ValidatorUtil.validate(requestAO));
    }

}