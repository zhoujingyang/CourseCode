package com.course.testng.suit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuitConfig {

    @BeforeSuite
    public void beforeSuit(){

        System.out.println("before suit run");
    }



    @AfterSuite
    public void afterSuit(){

        System.out.println("after suit run");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("before test run");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after test run");

    }

}
