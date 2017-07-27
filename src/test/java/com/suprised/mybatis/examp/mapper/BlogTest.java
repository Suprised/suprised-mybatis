package com.suprised.mybatis.examp.mapper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BlogTest {
    
    private static SqlSessionFactory sqlSessionFactory = null;

    @BeforeClass
    public static void classBefore() throws IOException {
        // ִֻ�� һ��
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    
    @Before
    public void methodBefore() {
        // ÿ������ִ��ǰִ��һ��
    }
    
    @Test
    public void getBlog() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Blog blog = session.selectOne("com.suprised.mybatis.examp.mapper.Blog.selectBlogAndAsso", 100);
            System.out.println(blog);
        }
    }
    
    @After
    public void methodAfter() {
        // ÿ������ִ�к�ִ��һ��
    }

    @AfterClass
    public static void classAfter() {
        // ִֻ��һ��
        sqlSessionFactory = null;
    }
}
