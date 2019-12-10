package com.share.ao;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 约束的继承演示
 * <p>
 * 借款人信息
 *
 * @author guozhe
 * @date 2019-12-04
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BorrowerAO extends UserAO {

    /**
     * 电话号码
     */
    @NotNull
    private Long mobile;

    /**
     * 电子邮件
     */
    @Email
    private String email;
    /**
     * 联系人列表
     */
    @NotEmpty(message = "联系人不能为空")
    private List<@Valid ContactAO> contact;
}
