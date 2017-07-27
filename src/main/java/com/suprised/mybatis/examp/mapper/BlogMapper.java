package com.suprised.mybatis.examp.mapper;

import org.apache.ibatis.annotations.Select;

public interface BlogMapper {
    
    @Select("SELECT * FROM blog WHERE id = #{id}")
    public Blog selectBlog(int id);
}
