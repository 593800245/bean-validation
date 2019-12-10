package com.share.ao;

import com.share.util.ValidatorUtil;
import org.junit.Test;

/**
 * @author guozhe
 * @date 2019-12-04
 */
public class TypeCheckingAOTest {

    /**
     * 测试报找不到校验器的异常
     */
    @Test(expected = Exception.class)
    public void test() {
        ValidatorUtil.validate(new TypeCheckingAO());
    }

}