package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class MyCookies {

    @Test
    public void getCookies() throws IOException {
        String url = "http://localhost:9999/post/with/cookies";

        DefaultHttpClient client = new DefaultHttpClient();
        JSONObject paramJson = new JSONObject();
        paramJson.put("zhangsan","20");
        StringEntity entity = new StringEntity(paramJson.toString(),"utf-8");
        entity.setContentType("application/json");
        HttpPost post = new HttpPost(url);


        post.setEntity(entity);
        HttpResponse response = client.execute(post);
        System.out.println(response.getEntity());

        CookieStore store = client.getCookieStore();

        List<Cookie> cookieList = store.getCookies();

        for(Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name =" + name + "cookie value =" + value);
        }

    }
    @Test
    public void getCookiesForGetMethod() throws IOException {
        String url = "http://localhost:9999/getCookies";

        DefaultHttpClient client = new DefaultHttpClient();

        HttpGet get = new HttpGet(url);

        HttpResponse response = client.execute(get);


        CookieStore store = client.getCookieStore();

        List<Cookie> cookieList = store.getCookies();

        for(Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name =" + name + "     cookie value =" + value);
        }



    }

}
