package com.share.ao;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Map;

/**
 * 容器元素的约束示例
 *
 * @author guozhe
 * @date 2019-12-03
 */
@Data
public class ContainerElementConstraintsAO {
    /**
     * 姓名列表
     */
    private List<@NotBlank String> names;
    /**
     * 姓名和年龄的对应关系
     */
    private Map<@NotBlank String, @Positive Integer> nameAgeMap;
}
