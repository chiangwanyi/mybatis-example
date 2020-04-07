package com.mapper;

import com.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int insertBlog(Blog blog);

    int deleteBlog(String id);

    int updateBlog(Blog blog);

    int updateBlogByMap(Map<String, Object> map);

    Blog queryBlogByID(String id);

    List<Blog> queryAllBlog();

    // 模糊查询
    List<Blog> searchBlogByTitleKey(String key);
}
