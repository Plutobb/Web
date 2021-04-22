package com.mopo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mopo.entity.TBlog;
import com.mopo.mapper.TBlogMapper;
import com.mopo.service.TBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 莫秃
 * @since 2021-04-10
 */
@Service
public class TBlogServiceImpl extends ServiceImpl<TBlogMapper, TBlog> implements TBlogService {

    @Autowired
    private TBlogMapper blogMapper;

    @Override
    public Page<TBlog> selectPage(Page<TBlog> pageBlog) {
        Page<TBlog> blogPage = blogMapper.selectPage(pageBlog, null);
        return blogPage;
    }

    @Override
    public TBlog selectById(Long id) {
        return blogMapper.selectById(id);
    }

    @Override
    public Page<TBlog> selectPage(Page<TBlog> page, QueryWrapper<TBlog> wrapper) {
        return blogMapper.selectPage(page, wrapper);
    }
}
