package com.tester.test;

import com.vimalselvam.testng.NodeName;
import com.vimalselvam.testng.listener.ExtentTestNgFormatter;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by zjy on 17/5/23.
 */
public class Demo {



   @Test
   public void testPost() throws IOException {
       Reporter.log("测试数据是啥啥啥");

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


   @Test(parameters = "p1" )
   public void test1(String p1){

       Reporter.log("Custom log1111111111111");
       System.out.println(p1);

  //     Assert.assertEquals(p1,"haha");

       ExtentTestNgFormatter.getInstance().setTestRunnerOutput("My outputMy outputMy outputMy outputMy outputMy outputMy output");
       NodeName.setNodeName("自己创建的");
       ExtentTestNgFormatter.getInstance().addNewNodeToTest();
       ExtentTestNgFormatter.getInstance().addInfoLogToNode("loglongljsdlkflsadlkd");
   }



    @Test
    public void test(){
       Assert.assertEquals(1,1);
    }
    @Test
    public void test11(){
        Assert.assertEquals(1,2);
    }

/*
    @AfterMethod
    public void afterMethod(ITestResult iTestResult) throws IOException {
        // The ITestResult is a mandatory parameter
        ExtentTestNgFormatter.getInstance().addScreenCaptureFromPath(iTestResult, "test-output/");
    }*/
}
