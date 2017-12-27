package com.course.client;

import com.google.common.base.Objects;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyClientForMysql {

    //这个对象就是连接数据库的会话
    private static volatile SqlSession sqlSession ;

    //指定配置文件路径
    private static final String CONFIGURATION_PATH = "conf/mybatis.xml";

    //将构造函数私有化的目的就是不可以new MyClientForMysql对象，只能使用下边的静态方法
    private MyClientForMysql(){

    }



    public  static  SqlSession getClient(){

        /**
         *  判断sqlSession对象是否为空，如果为空则new，不为空则直接返回，避免
         *  浪费内存空间
         */

        if (Objects.equal(sqlSession, null)) {
            //同步代码块，加锁的目的是避免多线程同步操作，如果写不好就是死锁
            synchronized (MyClientForMysql.class){
                /**
                 *  再次判断sqlSession是否为空，原因是有可能一个线程在外层判断
                 *  完sqlSession为空，在等待锁的过程中sqlSession已经为另外一个
                 *  线程赋值了，造成资源浪费
                 */
                if(Objects.equal(sqlSession,null)){
                    InputStream in = MyClientForMysql.class.getClassLoader().getResourceAsStream(CONFIGURATION_PATH);

                      //environment 属性指的就是mybatis.xml配置文件档中<environment id="development">
                    sqlSession = new SqlSessionFactoryBuilder().build(in,"development").openSession();
                }
            }

        }
        return sqlSession;
    }

}
