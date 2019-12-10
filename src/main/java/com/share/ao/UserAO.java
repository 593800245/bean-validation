package com.share.ao;

import com.share.enums.GenderEnum;
import com.share.validator.ValidEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author guozhe
 * @date 2019-11-13
 */
@NoArgsConstructor
@Data
public class UserAO {

    /**
     * 最小年龄
     */
    private static final int MIN_AGE = 18;
    /**
     * 最大年龄
     */
    private static final int MAX_AGE = 50;
    /**
     * 字段级别的约束示例
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    @Length(min = 2, max = 64)
    private String name;

    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空")
    // TODO: 2019-11-13 此处可以展示group
    @Range(min = MIN_AGE, max = MAX_AGE, message = "年龄必须在" + MIN_AGE + "至" + MAX_AGE + "岁之间")
    @Range()
    @Max(MAX_AGE)
    @Min(MIN_AGE)
    private Integer age;

    /**
     * 身份证号
     */
    @NotBlank
    // TODO: 2019-11-14 可以展示身份证号的正则表达式
    private String idNo;

    /**
     *
     */
    @NotBlank
    @ValidEnum(value = GenderEnum.class)
    private String gender;


}
