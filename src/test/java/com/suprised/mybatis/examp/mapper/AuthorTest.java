package com.suprised.mybatis.examp.mapper;

import java.io.IOException;
import java.io.InputStream;
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

public class AuthorTest {
    
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
    public void selectAuthors() {
        try (SqlSession session = sqlSessionFactory.openSession()){
            List<Author> authors = session.selectList("com.suprised.mybatis.examp.mapper.Author.selectAuthors");
            Assert.assertNotNull(authors);
            Assert.assertEquals(3, authors.size());
        }
    }
    
    @Test
    public void addAuthor() {
        try (SqlSession session = sqlSessionFactory.openSession()){
            session.insert("com.suprised.mybatis.examp.mapper.Author.insertAuthor", getAuthor(3));
            session.commit();
        }
    }
    
    
    public Author getAuthor(int id) {
        Author author = new Author(id, "liujinxi", "password", "ljx@dascom.cn");
        return author;
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
