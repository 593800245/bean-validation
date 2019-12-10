package com.share.ao;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

/**
 * 属性（非方法）级别的约束示例
 *
 * @author guozhe
 * @date 2019-12-03
 */
public class PropertyLevelConstraintsAO {

    /**
     * 姓名
     */
    private String name;

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 为什么是属性（非方法）级别的约束示例
     * 因为这个方法并没有被校验
     * TODO: 2019-12-04 为什么不校验?
     */
    @NotNull
    public String giveMeName() {
        return this.name;
    }

    /**
     * 为什么是属性（非方法）级别的约束示例
     * 因为这个方法并没有被校验
     */
    public @NotNull String giveMeName2() {
        return this.name;
    }

    /**
     * 此处为了演示欺骗校验器的情况，假装此方法是某个boolean字段的get方法让校验器校验此方法的返回值
     * 这样使用容易产生误会，还是不要使用；原因引用阿里java开发手册中的一个建议：
     * <p>
     * 阿里巴巴
     * 【强制】POJO 类中布尔类型的变量，都不要加 is 前缀，否则部分框架解析会引起序列化错误。
     * 反例:定义为基本数据类型Boolean isDeleted的属性，它的方法也是isDeleted()，RPC框架在反向解析的时候，“误以为”对应的属性名称是 deleted，导致属性获取不到，进而抛
     * 出异常。
     *
     * @return 名字不为null时返回true，否则返回false
     */
    @AssertTrue
    public boolean isNameIsNull() {
        return null != this.name;
    }

}
