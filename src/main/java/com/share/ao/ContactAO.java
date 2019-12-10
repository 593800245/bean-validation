package com.share.ao;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 联系人信息
 *
 * @author guozhe
 */
@Data
public class ContactAO {

    /**
     * 联系人姓名
     */
    @NotBlank(message = "联系人姓名不能为空")
    private String name;
    /**
     * 关系
     */
    @NotBlank(message = "联系人关系不能为空")
    private String relation;
    /**
     * 手机号码
     */
    @NotBlank(message = "联系人手机号码不能为空")
    private String phoneNo;
    /**
     * 地址
     */
    private String address;

}
