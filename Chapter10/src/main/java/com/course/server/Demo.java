package com.course.server;

import org.springframework.web.bind.annotation.*;

/**
 * Created by 大周 on 17/6/20.
 */
@RestController
@RequestMapping("/demo")
public class Demo {

    @RequestMapping(value = ("get"), method = RequestMethod.GET)
    public String getDemo(){

        return "hello spring boot";
    }

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public String postDemo(@RequestBody String str){
        String result = "你输入的数据是 : " + str;
        return  result;
    }



}

