package com.share.ao;

import com.google.common.collect.Maps;
import com.share.enums.GenderEnum;
import com.share.util.PrintUtil;
import com.share.util.ValidatorUtil;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import java.util.Map;
import java.util.Set;

/**
 * @author guozhe
 * @date 2019-12-26
 */
public class StudentTest {

    /**
     * 性别和校验组对应关系
     */
    private static final Map<String, Class> GROUP_MAP = Maps.newHashMap();

    @BeforeClass
    public static void initGroupMap() {
        GROUP_MAP.put(GenderEnum.MALE.name(), PersonGroup.MaleStudentGroup.class);
        GROUP_MAP.put(GenderEnum.FEMALE.name(), PersonGroup.FemaleStudentGroup.class);
    }

    @Test
    public void validateHairLengthWithGroup() {
        // 不良少年
        Student buliangshaonian = getStudent(GenderEnum.MALE, 200);
        validateStudentWithGroup(buliangshaonian, "不良少年", 1);
        // 不良少年理发了
        buliangshaonian.setHairLength(2);
        validateStudentWithGroup(buliangshaonian, "不良少年理发了", 0);

        // 女学生
        Student nvxuesheng = getStudent(GenderEnum.FEMALE, 2);
        validateStudentWithGroup(nvxuesheng, "女学生", 1);
        // 女学生头发长长了
        nvxuesheng.setHairLength(200);
        validateStudentWithGroup(nvxuesheng, "女学生头发长长了", 0);
    }

    /**
     * 分组校验学生
     *
     * @param student                 待校验的学生
     * @param messagePrefix           错误信息前缀
     * @param constraintViolationSize 期待的违反约束的条数
     */
    private void validateStudentWithGroup(Student student, String messagePrefix, int constraintViolationSize) {
        Set<ConstraintViolation<Student>> validate = ValidatorUtil.validate(student, GROUP_MAP.get(student.getGender()));
        Assert.assertEquals(constraintViolationSize, validate.size());
        PrintUtil.print(validate, messagePrefix);
    }

    @Test
    public void validateHairLengthWithOutGroup() {
        Set<ConstraintViolation<Student>> validate = ValidatorUtil.validate(getStudent(GenderEnum.MALE, -1));
        PrintUtil.print(validate, "头发长度");
    }

    /**
     * 获取一个学生
     *
     * @param gender     性别
     * @param hairLength 头发长度
     * @return 学生
     */
    private Student getStudent(GenderEnum gender, int hairLength) {
        Student student = new Student();
        student.setGender(gender.name());
        student.setHairLength(hairLength);
        return student;
    }

}