package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass2 {

    public void stu1(){
        System.out.println("GroupsOnClass2 stu1 run ");
    }

    public void stu2(){
        System.out.println("GroupsOnClass2 stu2 run ");
    }
}
