package com.course.httpclient.demo;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ResourceBundle;


public class MyHttpClient {


    private String getUrl;
    private ResourceBundle bundle;
    @BeforeTest
    public void before(){

        getUrl = bundle.getString("demo.get.url");
    }

    /**
     * get请求
     */
    @Test
    public  void testGet() throws IOException {

        String result;
        HttpGet get = new HttpGet(this.getUrl);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result= EntityUtils.toString(response.getEntity(),"utf-8");

        System.out.println(result);

        System.out.println(bundle.getString("demo.get.testdata"));

    }

    @Test
    public void testPost() throws IOException {

        String url = "http://localhost:8888/platform/project/add";
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        JSONObject paramJson = new JSONObject();
        paramJson.put("projectName","aaaaa");




        StringEntity entity = new StringEntity(paramJson.toString(),"utf-8");
        entity.setContentEncoding("utf-8");
        entity.setContentType("application/json");
        post.setEntity(entity);

        HttpResponse response = client.execute(post);

        System.out.println(EntityUtils.toString(response.getEntity()));

    }



}
