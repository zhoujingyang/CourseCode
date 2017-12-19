package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {


    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){

        System.out.println("RunTimeException!!!");

    }


    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){

        System.out.println("RunTimeException!!!");
        throw new RuntimeException();

    }

}
