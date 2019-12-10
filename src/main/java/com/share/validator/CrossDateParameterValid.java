package com.share.validator;

import java.util.Date;

/**
 * 交叉参数-两个日期比较的校验接口
 * 如果有bean里面有两个日期需要比较，则可以实现这个接口并且在类上加
 * ValidCrossDateParameter注解校验
 * 此类是交叉验证多个字段的另一种方式，功能能够满足，但是是否优雅可取后续再确认
 *
 * @author guozhe
 * @date 2019-12-03
 */
public interface CrossDateParameterValid {

    /**
     * 获取待校验的较早的日期
     *
     * @return 待校验的较早的日期
     */
    Date getEarlierDate();

    /**
     * 获取待校验的较晚的日期
     *
     * @return 待校验的较晚的日期
     */
    Date getLaterDate();

}
