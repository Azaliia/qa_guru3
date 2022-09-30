package com.demoqa.tests;

import org.junit.jupiter.api.*;

public class JUnitDemotest {

    @BeforeAll
    static void setUp()
    {
        System.out.println("### @BeforeAll !");
    }

    @BeforeEach
    void beforeEachTest()
    {
        System.out.println("### @BeforeEach!");
    }

    @AfterEach
    void afterEachTest()
    {
        System.out.println("### @afterEach!");
    }

    @Test
    void simpleTestFirst(){
        System.out.println("### @Test simpleTestFirst()!");
        Assertions.assertTrue(3>2);
    }

    @Test
    void simpleTestSecond(){
        System.out.println("### @Test simpleTestSecond()!");
        Assertions.assertTrue(3>2);
    }

    @AfterAll
    static void setdown()
    {
        System.out.println("### @AfterAll !");
    }
}
