package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {


    @Test(enabled = true)
    public void ignore1(){
        System.out.println("enabled = true");
    }


    @Test //演示默认 enabled=true
    public void ignore2(){
        System.out.println("default!!!");
    }


    @Test(enabled = false)
    public void ignore3(){
        System.out.println("enabled = false");
    }
}
