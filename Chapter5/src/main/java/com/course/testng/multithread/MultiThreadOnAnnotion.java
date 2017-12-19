package com.course.testng.multithread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotion {

    @Test(invocationCount = 10)
    public void test(){
        System.out.println(1);
    }


    @Test(invocationCount = 4 ,threadPoolSize = 3)
    public void test1(){
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }
}
