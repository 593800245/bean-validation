package com.share.ao;

import com.share.constant.Constant;
import com.share.enums.PaySource;
import com.share.validator.ValidEnum;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 某借贷业务请求AO
 * 示例所有的现有的constraint
 *
 * @author guozhe
 * @date 2019-11-08
 */
@Data
public class RequestAO {

    // Bean Validation 规范 constraint;使用JSR-380版本 start
    /**
     * 请求ID
     */
    @Null
    private String requestId;

    /**
     * 贷款人信息
     */
    @NotNull(message = "用户信息不允许为null")
    @Valid
    private BorrowerAO user;

    /**
     * 目标资金渠道,可以有多个目标资金渠道
     */
    @Size(min = 0, max = 3, message = "目标资金渠道的个数必须大于等于0小于等于3")
    @NotEmpty
    private List<@ValidEnum(value = PaySource.class, message = "目标资金渠道的值不正确") String> targetSources;

    /**
     * 签约金额
     */
    @Digits(integer = 6, fraction = 2, message = "签约金额整数位数不能超过12位，小数位数不能超过2位")
    @DecimalMax(value = "200000", message = "个人在同一平台上最多借款不能超过20万元")
    private BigDecimal signedAmount;

    /**
     * 放款金额
     */
    @DecimalMin(value = "0", inclusive = false, message = "放款金额必须大于0")
    @PositiveOrZero
    private BigDecimal amount;

    /**
     * 是否是男性
     */
    @AssertTrue(message = "借款人必须是男性，没有性别歧视；男人负责赚钱养家,女人负责貌美如花")
    private Boolean male;

    /**
     * 是否是女性
     */
    @AssertFalse(message = "借款人不能是女性，没有性别歧视；男人负责赚钱养家,女人负责貌美如花")
    private Boolean female;

    /**
     * 首期账单日
     */
    @Future(message = "首期账单日必须在当前时间之后")
    @FutureOrPresent(message = "首期账单日必须是当前时间或之后")
    private Date firstDueDate;

    /**
     * 实际放款时间
     */
    @Past(message = "实际放款时间必须在当前时间之前")
    @PastOrPresent(message = "实际放款时间必须是当前时间或之前")
    private Date loanTime;

    /**
     * 借款人年龄
     */
    @Min(22)
    @Max(50)
    @Positive(message = "必须是正数")
    private Integer age;

    /**
     * 邮箱
     * <p>
     * {@code NotBlank}和{@code NotEmpty}用在字符串上的时候效果是一样的
     */
    @Pattern(regexp = Constant.EMAIL_REGEXP)
    @Email
    @NotBlank
    @NotEmpty
    @org.hibernate.validator.constraints.Email
    private String email;

    /**
     * 减免金额
     */
    @Negative(message = "必须是负数")
    @NegativeOrZero(message = "必须是负数")
    private BigDecimal reduceAmount;


    // Bean Validation 规范 constraint;使用JSR-380版本 end


    // Hibernate Validator 扩展的约束（constraint）演示start

    /**
     * 合同编号
     */
    @Length(min = 8, max = 32)
    private String contractCode;

    /**
     * 借款人年龄
     * 两边都是闭区间
     * 即age1必须大于等于22小于等于55
     */
    @Range(min = 22, max = 55)
    @Positive(message = "必须是正数")
    private Integer age1;

    // Hibernate Validator 扩展的约束（constraint）演示end


}
