package com.course.server;

import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class GetMethod {


    /**
     * 登录获取cookies
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@CookieValue("true") String login) {

        System.out.println(login);
        return "login + " + login;
    }


    @RequestMapping(value = "/get/with/param/{a}",method = RequestMethod.GET)
    public void getWithParam(@PathVariable("a") String nickName){
        System.out.println("name = " + nickName);
    }

}
