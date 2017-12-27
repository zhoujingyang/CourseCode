package tester.test;

import com.tester.client.DemoConfClient;
import com.tester.model.HttpDefaultConf;
import com.vimalselvam.testng.NodeName;
import com.vimalselvam.testng.listener.ExtentTestNgFormatter;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by zjy on 17/5/23.
 */
public class Demo {

    private String getUrl;
    private ResourceBundle bundle;
    @BeforeTest
    public void before(){

        bundle = DemoConfClient.getDemoConf();
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

    public static void main(String[] args) {
        int i = 1;
        String j = "2";


        System.out.println(i+j);

        HttpDefaultConf conf = new HttpDefaultConf();
        System.out.println(conf.getEncoding());

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
