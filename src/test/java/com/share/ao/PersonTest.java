package com.share.ao;

import com.share.enums.GenderEnum;
import com.share.util.PrintUtil;
import com.share.util.ValidatorUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author guozhe
 * @date 2019-12-26
 */
class PersonTest {

    @Test
    void testGenderError() {
        Person person = new Person();
        person.setGender("test");
        Set<ConstraintViolation<Person>> validate = ValidatorUtil.validate(person);
        Assert.assertEquals(1, validate.size());
        PrintUtil.print(validate, "testGenderError");
    }

    @Test
    void testGender() {
        Person person = new Person();
        person.setGender(GenderEnum.MALE.name());
        Set<ConstraintViolation<Person>> validate = ValidatorUtil.validate(person);
        Assert.assertEquals(0, validate.size());
    }

}