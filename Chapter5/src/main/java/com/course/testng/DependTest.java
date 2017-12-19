package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {

    @Test
    public void test1(){

        System.out.println("test1 run");

//        throw new RuntimeException();  此处设置异常抛出进行演示，如果test1抛出一场，则test2将会被忽略
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run");
    }
}
