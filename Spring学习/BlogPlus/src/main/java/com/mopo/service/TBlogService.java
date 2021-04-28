package com.mopo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mopo.entity.TBlog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 莫秃
 * @since 2021-04-10
 */
public interface TBlogService extends IService<TBlog> {

    Page<TBlog> selectPage(Page<TBlog> page);

    TBlog selectById(Long id);

    Page<TBlog> selectPage(Page<TBlog> page, QueryWrapper<TBlog> wrapper);

    List<TBlog> selectBlogAndTypeNameById(QueryWrapper<TBlog> wrapper);

}
