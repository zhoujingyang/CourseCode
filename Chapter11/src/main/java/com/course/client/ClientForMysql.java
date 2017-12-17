package com.course.client;

import com.google.common.base.Objects;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by zjy on 17/5/5.
 */

public class ClientForMysql {

    private static volatile SqlSession licaiBizSession ;
    private static volatile SqlSession licaiBizRealTimeSession ;
    private static volatile SqlSession licaiInfoSession ;
    private static volatile SqlSession licaiResultSession ;

    private static final String CONFIGURATION_PATH = "conf/mybatis.xml";


    private ClientForMysql(){

    }

    public  static  SqlSession getLicaiBizClient(){


        if (Objects.equal(licaiBizSession, null)) {
            synchronized (ClientForMysql.class){
                if(Objects.equal(licaiBizSession,null)){
                    InputStream in = ClientForMysql.class.getClassLoader().getResourceAsStream(CONFIGURATION_PATH);
                    licaiBizSession = new SqlSessionFactoryBuilder().build(in,"licaibiz").openSession();
                }
            }

        }
        return licaiBizSession;
    }


    public  static  SqlSession getLicaiBizRealTimeClient(){


        if (Objects.equal(licaiBizRealTimeSession, null)) {
            synchronized (ClientForMysql.class){
                if(Objects.equal(licaiBizRealTimeSession,null)){
                    InputStream in = ClientForMysql.class.getClassLoader().getResourceAsStream(CONFIGURATION_PATH);
                    licaiBizRealTimeSession = new SqlSessionFactoryBuilder().build(in,"licaibiz").openSession();
                }
            }

        }
        return licaiBizRealTimeSession;
    }


    public  static SqlSession getLicaiInfoClient(){

        if(Objects.equal(licaiInfoSession, null)){
            synchronized (ClientForMysql.class){
                if(Objects.equal(licaiInfoSession,null)){
                    InputStream in = ClientForMysql.class.getClassLoader().getResourceAsStream(CONFIGURATION_PATH);
                    licaiInfoSession = new SqlSessionFactoryBuilder().build(in,"licaiinfo").openSession();
                }
            }
        }
        return licaiInfoSession;
    }

    public  static SqlSession getLicaiResultClient(){

        if(Objects.equal(licaiResultSession, null)){
            synchronized (ClientForMysql.class){
                if(Objects.equal(licaiResultSession,null)){
                    InputStream in = ClientForMysql.class.getClassLoader().getResourceAsStream(CONFIGURATION_PATH);
                    licaiResultSession = new SqlSessionFactoryBuilder().build(in,"licairesult").openSession();
                }
            }
        }
        return licaiResultSession;
    }


/*

    public static void main(String[] args) throws IOException {

        String resource = "conf/mybatis.xml";
        InputStream in = ClientForMysql.class.getClassLoader().getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in,"licaibiz");


        licaiBizSession = sqlSessionFactory.openSession();
        String s = "mapping.licaiBizMapping.getUser";
        System.out.printf(user.toString());
    }
*/




}
