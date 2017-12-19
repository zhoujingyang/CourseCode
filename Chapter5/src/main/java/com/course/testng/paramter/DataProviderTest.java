package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {


    //dataProvider 支持对象的传递
    @Test(dataProvider = "data")
    public void testDataProvider(String name,int sex){
        System.out.println("name = " + name + ";;;" + "sex  = " + sex);
    }

    @DataProvider(name = "data")
    public Object[][] providerData(){

        Object[][] o = new Object[][]{{"zhangsan",10},{"lisi",20}};
        return o;
    }



    //dataProvider 支持不同的方法传递不同的参数

    @Test(dataProvider = "methodData")
    public void test1(String name , int sex){
        System.out.println("test1 run ::: " + "name = " + name + ";;;" + "sex  = " + sex);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name,int sex){
        System.out.println("test2 run ::: " + "name = " + name + ";;;" + "sex  = " + sex);
    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method){

        Object[][] result = null;

        if (method.getName().equals("test1")) {
            result = new Object[][] {
                    { "zhangsan", 20 }, { "lisi", 25 }
            };
        } else if (method.getName().equals("test2")) {
            result = new Object[][] {
                    { "wangwu", 50 },
                    { "zhao6", 60 }
            };
        }

        return result;




    }
}
