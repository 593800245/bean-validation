package com.share.ao;

import com.share.enums.GenderEnum;
import com.share.validator.ValidEnum;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author guozhe
 * @date 2019-12-25
 */
@Data
public class Person {

    /**
     * 性别
     * 有些人会对这里有些疑问，为什么有枚举类型{@code GenderEnum}不用而要用{@code String}类型呢
     * 可以演示：ValidationController#pushToPaySourceEnum
     */
    @ValidEnum(value = GenderEnum.class)
    @NotNull
    private String gender;
    /**
     * 头发长度，单位cm
     */
    @Min(0)
    private Integer hairLength;

}
