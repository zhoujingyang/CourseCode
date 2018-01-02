package com.course.server;


import com.course.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class PostMethod {


    /**
     *  一般在企业中cookie信息都是存在redis数据库中
     *  原因是redis可以自动设置key的有效时间，不用我们自己写代码进行维护
     *  只需要查询和写入即可
     */
    private static Cookie cookie;

    /**
     * 登录,请求为key value
     * 写入cookie
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String userName,
                        @RequestParam(value = "password", required = true) String password){

        System.out.println(userName);
        System.out.println(password);
        //验证用户名密码是否正确
        if (userName.equals("zhangsan") && password.equals("1234")){
            //设置响应结果中的cookie
            cookie = new Cookie("login","true");
            response.addCookie(cookie);
            //返回登录成功信息
            return "login seccess";
        }

        return null;
    }


    /**
     * 1、jmeter的bin目录下jmeter.properties的文件
     开放这个：CookieManager.save.cookies=true
     2、Http请求下添加Http Cookie管理器（空的足够）
     3、使用debug sampler就可以查看到cookie的名称
     4、则在整个测试计划需要获取的cookie值为${COOKIE_***}，前面的COOKIE为jmeter命名规则
     * 如果实际测试过程中，不知道cookie都有哪些。1，可以问开发。 2，使用fiddler工具抓
     */


    //@RequestBody 默认为json格式的数据 spring会把参数和bean自动对应起来
    //要求带着cookies访问
    @RequestMapping(value = "/post/with/param",method = RequestMethod.POST)
    public String postDemo(@RequestBody User str, HttpServletRequest request){

        Cookie[] cookies = request.getCookies();

        for(Cookie c : cookies){
            System.out.println(c.getName());
            System.out.println(c.getValue());

            //客户端传入的cookie与上一个方法中自己生成的cookie做比较
            if(c.getName().equals(cookie.getName())
                    && c.getValue().equals(cookie.getValue())){
                return "you win";
            }

        }

        System.out.println(str.getName());
        System.out.println(str.getAge());
        System.out.println(str.getSex());
        return  "failed";
    }

}
