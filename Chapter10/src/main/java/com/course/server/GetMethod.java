package com.course.server;

import com.course.bean.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(@RequestParam Integer start, @RequestParam Integer end) {
        Map<String, Integer> params = Maps.newHashMap();
        params.put("start", start);
        params.put("end", end);
        Map<String, Object> values = Maps.newHashMap();
        values.put("data", sqlSessionTemplate.selectList("guowang.mapper.GetFeedbackList", params));
        values.put("count", sqlSessionTemplate.selectOne("guowang.mapper.GetFeedbackCount"));
        return values;
    }

    @RequestMapping(value = "news/{id}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "返回新闻详情")
    public News get(@PathVariable Integer id) {
        return sqlSessionTemplate.selectOne("guowang.mapper.GetNews", id);
    }


}
