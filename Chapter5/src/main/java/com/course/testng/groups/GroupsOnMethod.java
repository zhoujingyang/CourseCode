package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("test 1  run");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("test 2  run");
    }


    @Test(groups = "client")
    public void test3(){
        System.out.println("test  3  run");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("test 4  run");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("before groups on server run");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("after groups on server run");
    }
}
