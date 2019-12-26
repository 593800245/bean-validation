package com.share.ao;

import com.share.enums.GenderEnum;
import com.share.validator.ValidEnum;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * @author guozhe
 * @date 2019-12-25
 */
@Data
public class Person {

    /**
     * 性别
     */
    @ValidEnum(value = GenderEnum.class)
    private String gender;
    /**
     * 头发长度，单位cm
     */
    @Range
    private Integer hairLength;

}
