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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class MyCookiesForGet {


    /**
     * 获取无参数get方法中的cookies
     * @throws IOException
     */
    @Test
    public void getCookiesForGetMethod() throws IOException {
        String url = "http://localhost:9999/getCookies";

        CookieStore store = getCookieStore(url);

        List<Cookie> cookieList = store.getCookies();

        for(Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name =" + name + "     cookie value =" + value);
        }
    }

    /**
     * 获取cookiestore
     * @param url
     * @return
     * @throws IOException
     */
    public CookieStore getCookieStore(String url) throws IOException {

        DefaultHttpClient client = new DefaultHttpClient();

        HttpGet get = new HttpGet(url);

        client.execute(get);

        return client.getCookieStore();
    }


    /**
     * 携带cookies访问
     * @throws IOException
     */
    @Test
    public void getCookiesForGetMethodWithHeader() throws IOException {
        //获取cookies的url
        String cookiesUrl = "http://localhost:9999/getCookies";

        //需要携带cookies的请求
        String url = "http://localhost:9999/get/with/cookies";

        DefaultHttpClient client = new DefaultHttpClient();

        HttpGet get = new HttpGet(url);

        client.setCookieStore(getCookieStore(cookiesUrl));//获取依赖的cookies

        HttpResponse response = client.execute(get);

        //获取响应码
        int statuscode = response.getStatusLine().getStatusCode();

        System.out.println(statuscode);

        //判断响应状态
        if(statuscode==200){
            //获取响应内容
            String result = getContent(response);
            System.out.println(result);
        }
    }


    /**
     * 获取响应内容
     * @param response
     * @return
     * @throws IOException
     */
    public String getContent(HttpResponse response) throws IOException {
        String result = null;

        InputStream in = response.getEntity().getContent();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        StringBuffer stringBuffer = new StringBuffer("");
        String line = "";
        while((line = bufferedReader.readLine())!=null){
            stringBuffer.append(line);
        }
        result= stringBuffer.toString();
        return result;
    }
}
