package com.mopo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mopo.entity.TBlog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 莫秃
 * @since 2021-04-10
 */
@Repository
public interface TBlogMapper extends BaseMapper<TBlog> {

    @Select("select t_blog.id, appreciation, commentabled, content, create_time, description, first_picture, flag, published, recommend, share_statement, title, update_time, views, type_id, user_id,tt.name as typeName from t_blog left join t_type tt on t_blog.type_id = tt.id ${ew.customSqlSegment}")
    public List<TBlog> findBlogAndTypeNameById(@Param(Constants.WRAPPER)QueryWrapper<TBlog> wrapper);

}
