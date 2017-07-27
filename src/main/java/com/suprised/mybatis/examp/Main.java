package com.suprised.mybatis.examp;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.suprised.mybatis.examp.mapper.Blog;
import com.suprised.mybatis.examp.mapper.BlogMapper;

public class Main {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        annotationMapper(sqlSessionFactory);
        xmlMapper(sqlSessionFactory);
    }
    
    /**
     * 注解的方式进行查询
     */
    public static void annotationMapper(SqlSessionFactory sqlSessionFactory) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            Blog blog = sqlSession.getMapper(BlogMapper.class).selectBlog(1);
            System.out.println(blog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * xml的方式进行查询 : 增删查改
     */
    public static void xmlMapper(SqlSessionFactory sqlSessionFactory) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Blog blog = sqlSession.selectOne("com.suprised.mybatis.examp.mapper.Blog.selectBlog", 1);
            Blog blog2 = sqlSession.selectOne("com.suprised.mybatis.examp.mapper.Blog.selectBlogByResultMap", 1);
            Blog blog3 = sqlSession.selectOne("com.suprised.mybatis.examp.mapper.Blog.selectBlogByResultMap", 100);
            System.out.println(blog + "," + blog2 + "," + blog3);
            
            int insertId = 101;
            sqlSession.insert("com.suprised.mybatis.examp.mapper.Blog.insertBlog", new Blog(insertId, "dascom"));
            
            Blog insertBlog = sqlSession.selectOne("com.suprised.mybatis.examp.mapper.Blog.selectBlog", insertId);
            System.out.println("insertBlog : " + insertBlog);
            
            int result = sqlSession.update("com.suprised.mybatis.examp.mapper.Blog.updateBlog", new Blog(insertId, "UpdateTitleById:" + insertId));
            System.out.println("update Blog : " + result);
            
            Blog updateBlog = sqlSession.selectOne("com.suprised.mybatis.examp.mapper.Blog.selectBlog", insertId);
            System.out.println("updateBlog : " + updateBlog);
            
            int delResult = sqlSession.delete("com.suprised.mybatis.examp.mapper.Blog.deleteBlog", insertId);
            System.out.println("delete Blog : " + delResult);
            
            Blog deleteBlog = sqlSession.selectOne("com.suprised.mybatis.examp.mapper.Blog.selectBlog", insertId);
            System.out.println("deleteBlog : " + deleteBlog);
            
            sqlSession.commit(); // 提交之后，上面的修改内容才会更新到数据库中
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
