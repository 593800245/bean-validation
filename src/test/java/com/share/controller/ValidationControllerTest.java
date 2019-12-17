package com.share.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author guozhe
 * @date 2019-12-16
 */
@SpringBootTest
class ValidationControllerTest {
    @Autowired
    private ValidationController validationController;

    @Test
    void hello() {

    }

    @Test
    void pushToPaySource() {
        validationController.pushToPaySource("hi");
    }

    @Test
    void receiveUser() {


    }

}