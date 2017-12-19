package com.course.testng;

import org.testng.annotations.*;


public class BasicAnnotation {

    // test case 1
    @Test
    public void testCase1() {
        System.out.println("Run test case 1");
    }

    // test case 2
    @Test
    public void testCase2() {
        System.out.println("Run test case 2");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Run beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Run afterMethod");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Run beforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Run afterClass");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Run beforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Run afterTest");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Run beforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Run afterSuite");
    }
}
