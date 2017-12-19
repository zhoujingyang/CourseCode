package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {


    public void teacher1(){
        System.out.println("GroupOnClass3 teacher1 run");
    }


    public void teacher2(){
        System.out.println("GroupOnClass3 teacher2 run");
    }
}
