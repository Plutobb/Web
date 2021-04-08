package com.mopo.mapper;

import com.mopo.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface BlogMapper {

    List<Blog> findTop();

    //Page<Blog> findByQuery();

    List<Blog> findAll();

    int updateViews(Long id);

    List<String> findGroupYear();

    List<Blog> findByYear(String year);

    Blog findById(Long id);
}
