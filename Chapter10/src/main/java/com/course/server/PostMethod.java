package com.course.server;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostMethod {


    //@RequestBody 默认为json格式的数据
    @RequestMapping(value = "/post/with/param",method = RequestMethod.POST)
    public String postDemo(@RequestBody String str,@RequestBody String name){
        System.out.println(str);
        System.out.println(name);
        return  str;
    }

}
