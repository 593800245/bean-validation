package com.share.util;

import com.share.enums.PaySource;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;


/**
 * @author guozhe
 * @date 2020-04-30
 */
public class EnumUtilTest {

    @Test(expected = RuntimeException.class)
    public void getValueNoEnum() {
        EnumUtil.getValue(PaySource.class, "hi", "支付渠道");
    }


    @Test
    public void getValue() {
        PaySource value = EnumUtil.getValue(PaySource.class, "BUGAOSUNI", "支付渠道");
        Assert.assertEquals(PaySource.BUGAOSUNI, value);
    }

    @Test
    public void converterToName() {
        Set<String> names = EnumUtil.listAllNames(PaySource.class);
        Assert.assertFalse(names.isEmpty());
    }

}