package com.mopo.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mopo.entity.TType;
import com.mopo.mapper.TTypeMapper;
import com.mopo.service.TTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 莫秃
 * @since 2021-04-10
 */
@Service
public class TTypeServiceImpl extends ServiceImpl<TTypeMapper, TType> implements TTypeService {

    @Autowired
    private TTypeMapper typeMapper;

    @Override
    public List<TType> list() {
        return typeMapper.selectList(null);
    }
}
