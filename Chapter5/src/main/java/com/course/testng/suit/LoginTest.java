package com.course.testng.suit;

import org.testng.annotations.Test;

public class LoginTest {


    @Test(groups = "ali")
    public void loginTaoBao(){
        System.out.println("taobao login success");
    }

    @Test(groups = "ali")
    public void loginAliPay(){
        System.out.println("aliPay login success");
    }

    @Test(groups = "tengxun")
    public void loginWeiXin(){
        System.out.println("weixin login success");
    }

    @Test(groups = "tengxun")
    public void loginCaiFuTong(){
        System.out.println("caifutong login success");
    }
}
