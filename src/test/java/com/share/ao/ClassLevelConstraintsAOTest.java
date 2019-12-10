package com.share.ao;

import com.share.util.PrintUtil;
import com.share.util.ValidatorUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.Date;

/**
 * @author guozhe
 * @date 2019-12-03
 */
public class ClassLevelConstraintsAOTest {

    @Test
    public void test() {
        ClassLevelConstraintsAO classLevelConstraintsAO = new ClassLevelConstraintsAO();
        Date now = new Date();
        classLevelConstraintsAO.setLoanDay(now);
        classLevelConstraintsAO.setLoanTime(DateUtils.addDays(now, -1));
        PrintUtil.print(ValidatorUtil.validate(classLevelConstraintsAO));
    }

}