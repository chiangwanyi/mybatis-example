package com.mapper;

import com.pojo.Blog;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void insertBlog() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            int i = mapper.insertBlog(new Blog("a", "test", "jwy", new Date(), 0));
            if (i == 1) {
                System.out.println("成功");
            }
            sqlSession.commit();
        }
    }

    @Test
    public void deleteBlog() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            int i = mapper.deleteBlog("a");
            if (i == 1) {
                System.out.println("成功");
            }
            sqlSession.commit();
        }
    }

    @Test
    public void updateBlog() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            int i = mapper.updateBlog(new Blog("5d47f00c86974c4db607a582706421a3", "修改了", "jwy", new Date(), 0));
            if (i == 1) {
                System.out.println("成功");
            }
            sqlSession.commit();
        }
    }

    @Test
    public void updateBlogByMap() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("bid", "00d42657c6b54b12b1315d9d29ef4d76");
            map.put("views", 0);
            int i = mapper.updateBlogByMap(map);
            if (i == 1) {
                System.out.println("成功");
            }
            sqlSession.commit();
        }
    }

    @Test
    public void queryBlogByID() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = mapper.queryBlogByID("00d42657c6b54b12b1315d9d29ef4d76");
            System.out.println(blog);
        }
    }

    @Test
    public void queryAllBlog() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            List<Blog> blogs = mapper.queryAllBlog();
            for (Blog blog : blogs) {
                System.out.println(blog);
            }
        }
    }

    @Test
    public void searchBlogByTitleKey() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            List<Blog> blogs = mapper.searchBlogByTitleKey("a");
            for (Blog blog : blogs) {
                System.out.println(blog);
            }
        }
    }
}
