package com.mopo.impl;

import com.mopo.entity.TUser;
import com.mopo.mapper.TUserMapper;
import com.mopo.service.TUserService;
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
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
