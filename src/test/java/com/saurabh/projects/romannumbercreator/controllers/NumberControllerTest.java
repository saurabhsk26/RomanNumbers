package com.saurabh.projects.romannumbercreator.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class NumberControllerTest {

    @Autowired
    NumberController numberController;

    @Test
    void checkRomanNumber(){

        String ExpectedResponse = "CXXIII";

        String ActualResponse = numberController.getRomanNumber("123");

        assertEquals(ExpectedResponse,ActualResponse);
    }
}
