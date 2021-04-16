package com.mopo.impl;

import com.mopo.entity.TComment;
import com.mopo.mapper.TCommentMapper;
import com.mopo.service.TCommentService;
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
public class TCommentServiceImpl extends ServiceImpl<TCommentMapper, TComment> implements TCommentService {

}
