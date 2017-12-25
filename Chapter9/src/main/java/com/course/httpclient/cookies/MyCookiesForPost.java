package com.course.httpclient.cookies;

import com.course.httpclient.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyCookiesForPost {

    //cookies存储的对象
    private static CookieStore store = null;
    //cookies 的 url存储的对象
    private static final String COOKIES_URL="http://localhost:9999/getCookies";
    //访问方法的url。 大写的原因是final修饰符的变量，一般都写成大写
    private static final String POST_URL="http://localhost:9999/post/with/cookies";

    /**
     * 在开始测试前，获取到cookies
     */
    @BeforeTest
    public void getCookies() throws IOException {
        store = HttpUtils.getCookieStore(COOKIES_URL);

    }

    /**
     * 携带cookies对post方法进行访问
     */
    @Test
    public void postMethodWithCookies() throws IOException {

        //声明client对象，用于进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();
        //post方法
        HttpPost post = new HttpPost(POST_URL);

        //创建参数对象
        JSONObject param = new JSONObject();
        //添加参数
        param.put("name","zhangsan");
        param.put("sex","20");

        //创建一个添加头信息的对象
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        //将参数添加到请求方法中
        post.setEntity(entity);
        //设置访问头信息
        post.setHeader("content-type","application/json");


        //存储最终访问结果
        String responseResult = "";

        //设置cookies信息
        client.setCookieStore(store);
        //执行post方法
        HttpResponse response = client.execute(post);

        //获取相应结果
        responseResult = HttpUtils.getContent(response);
        System.out.println(responseResult);

        //结果处理
        //将返回结果转化为json对象
        JSONObject resultJson = new JSONObject(responseResult);
        //获取到zhangsan的登录结果
        String success = (String) resultJson.get("zhangsan");
        System.out.println(success);

        //判断返回结果值
        Assert.assertEquals("success",success);

        String status = (String) resultJson.get("status");
        System.out.println(status);
        Assert.assertEquals("1",status);
    }
}
