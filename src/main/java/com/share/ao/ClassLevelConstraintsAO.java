package com.share.ao;

import com.share.validator.CrossDateParameterValid;
import com.share.validator.ValidCrossDateParameter;
import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 字段级别的约束示例
 * @author guozhe
 * @date 2019-12-03
 */
@Data
@ValidCrossDateParameter(message = "预计放款时间必须在实际放款时间之前")
public class ClassLevelConstraintsAO implements CrossDateParameterValid {

    /**
     * 预计放款时间
     */
    @NotNull
    private Date loanDay;
    /**
     * 实际放款时间
     */
    @NotNull
    private Date loanTime;

    @Override
    public Date getEarlierDate() {
        return loanDay;
    }

    @Override
    public Date getLaterDate() {
        return loanTime;
    }

    /**
     * 此处用到了属性校验的一个特性，只会校验get方法和（is开头的方法是boolean类型的字段的get方法），
     */
    @AssertTrue(message = "预计放款时间必须在实际放款时间之前")
    public boolean isLoanDayBeforeLoanTime() {
        return this.loanDay.before(this.loanTime);
    }

    /**
     * 此处用到了属性校验的一个特性，只会校验get方法和（is开头的方法是boolean类型的字段的get方法），
     */
    public @AssertTrue boolean isLoanDayBeforeLoanTime2() {
        return this.loanDay.before(this.loanTime);
    }
}
