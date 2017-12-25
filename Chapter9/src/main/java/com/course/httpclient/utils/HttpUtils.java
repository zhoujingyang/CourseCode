package com.course.httpclient.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpUtils {

    /**
     * 获取响应内容
     * @param response
     * @return
     * @throws IOException
     */
    public static String getContent(HttpResponse response) throws IOException {
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



    /**
     * 获取cookiestore
     * @param url
     * @return
     * @throws IOException
     */
    public static CookieStore getCookieStore(String url) throws IOException {

        DefaultHttpClient client = new DefaultHttpClient();

        HttpGet get = new HttpGet(url);

        client.execute(get);

        return client.getCookieStore();
    }
}
