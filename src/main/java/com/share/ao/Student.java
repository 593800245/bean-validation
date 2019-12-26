package com.share.ao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;

/**
 * @author guozhe
 * @date 2019-12-25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Student extends Person {

    /**
     * 头发长度，男学生一般要求头发不能太长，所以头发长度不能超过10厘米
     * 此字段覆盖了父类的字段，相应的属性注解也覆盖了；虽然父类又{@code @Min(0)}但是并没有生效，所以在此处要有{@code @Min(0)}
     */
    @Range(max = 10, groups = PersonGroup.MaleStudentGroup.class, message = "本校规定男学生头发长度不能超过10厘米")
    @Range(min = 10, groups = PersonGroup.FemaleStudentGroup.class, message = "本校规定女学生头发长度不能短于10厘米")
    @Min(0)
    private Integer hairLength;

}
