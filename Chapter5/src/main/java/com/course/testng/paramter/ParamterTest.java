package com.course.testng.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterTest {

    @Test
    @Parameters({"name","sex"})
    public void paramTest1(String name,int sex){
        System.out.println("name = " + name + ";;;" + "sex  = " + sex);

    }
}
