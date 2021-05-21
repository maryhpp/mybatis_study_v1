package com.kuang.dao;

import com.kuang.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    //插入数据
    int addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIF(Map map);

    //更新博客
    int updateBlog(Map map);


    List<Blog> queryBlogChoose(Map map);

    //查询1-2-3号记录的博客
    List<Blog> queryBlogForeach(Map map);
}
