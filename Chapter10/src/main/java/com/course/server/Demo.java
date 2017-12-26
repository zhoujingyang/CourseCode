package com.course.server;

import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;
import org.testng.annotations.Test;

@Log4j
@RestController
public class Demo {

    @RequestMapping(value = ("get"), method = RequestMethod.GET)
    public String getDemo(){
        log.info("hahah");
        return "hello spring boot";
    }


    //@RequestBody 默认为json格式的数据
    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public String postDemo(){
        return  "post 访问成功";
    }




}

