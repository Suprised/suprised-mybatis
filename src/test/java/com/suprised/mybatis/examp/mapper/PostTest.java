package com.suprised.mybatis.examp.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PostTest {
    
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
    public void selectPosts() {
        try (SqlSession session = sqlSessionFactory.openSession()){
            List<Post> posts = session.selectList("com.suprised.mybatis.examp.mapper.Post.selectPosts");
            Assert.assertNotNull(posts);
            Assert.assertEquals(10, posts.size());
        }
    }
    
    @Test
    public void addPosts() {
        try (SqlSession session = sqlSessionFactory.openSession()){
            session.insert("com.suprised.mybatis.examp.mapper.Post.insertPosts", getPosts());
            session.commit();
        }
    }
    
    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<Post>();
        for (int i=0; i<10; i++) {
            posts.add(new Post(i, i + 10, "this is post content : " + i, new Blog(100)));
        }
        return posts;
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
