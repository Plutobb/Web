package com.mopo.impl;

import com.mopo.entity.TBlog;
import com.mopo.mapper.TBlogMapper;
import com.mopo.service.TBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
