package com.course.testng.suit;

import org.testng.annotations.Test;

public class PayTest {

    @Test(groups = {"ali", "tengxun"})
    public void payWeipinhui(){
        System.out.println("weipinhui pay success");
    }

    @Test(groups = "tengxun")
    public void payJD(){
        System.out.println("jingdong pay success");
    }
}
