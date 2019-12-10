package com.share.ao;

import com.share.util.PrintUtil;
import com.share.util.ValidatorUtil;
import org.junit.Test;

/**
 * @author guozhe
 * @date 2019-12-03
 */
public class FieldLevelConstraintsAOTest {

    @Test
   public void getName() {
        PrintUtil.print(ValidatorUtil.validate(new FieldLevelConstraintsAO()));
    }

}