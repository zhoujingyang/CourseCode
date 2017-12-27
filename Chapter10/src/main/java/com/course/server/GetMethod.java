package com.course.server;

import com.course.bean.User;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;

@RestController
public class GetMethod {


    /**
     * 返回cookies接口，无参数的请求
     */
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response) {

        Cookie hit = new Cookie("login", "true");

        response.addCookie(hit);
        return "success";
    }


    /**
     * 要求携带cookie访问,无参数的请求
     * 客户端访问需要加上域和路径 localhost  和  /
     * @param httpRequest
     * @return
     */
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    public String getWithParam(HttpServletRequest httpRequest){
        User user = null;
        Cookie[] cookies = httpRequest.getCookies();
        if(Objects.isNull(cookies)){
            return "failed";
        }
        for(Cookie cookie : cookies){
            //验证cookie信息,正常开发中，一般是从redis中取出cookie信息进行验证
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
                user = new User();
                user.setName("zhangsan");
                user.setAge(20);
                user.setSex("man");
                return user.toString();
            }

        }

        return "cookie failed";

    }


    /**
     * 带参数的get请求，验证cookie，返回信息，真正请求中需要查询数据库
     * http://localhost:8888/get/with/param?start=1&end=10  得到结果
     */
    @RequestMapping(value = "/get/with/param", method = RequestMethod.GET)
    public Map<String, Integer> list(HttpServletRequest httpRequest,@RequestParam Integer start, @RequestParam Integer end) {
        Map<String, Integer> params = Maps.newHashMap();
        params.put("start", start);
        params.put("end", end);

        //可以设置返回某商品列表


        return params;
    }

    /**
     * 带路径参数的get请求，单个参数
     * 访问http://localhost:8888/get/with/path/param/1   得到结果
     * @param id
     * @return
     */
    @RequestMapping(value = "get/with/path/param/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Integer id) {
        return "您输入的是 : "+id;
    }
    /**
     * 带路径参数的get请求，多个参数
     * 访问http://localhost:8888/get/with/path/param/1/12   得到结果
     * @param id
     * @return
     */
    @RequestMapping(value = "get/with/path/param/{id}/{no}", method = RequestMethod.GET)
    public String get(@PathVariable Integer id,@PathVariable Integer no) {
        return "您输入的是 id = "+id + "   no = " + no;
    }


}
