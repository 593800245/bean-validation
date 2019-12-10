package com.share.ao;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 字段级别的约束示例
 *
 * @author guozhe
 * @date 2019-12-03
 */
@Data
public class FieldLevelConstraintsAO {

    @NotBlank
    private String name;

}
