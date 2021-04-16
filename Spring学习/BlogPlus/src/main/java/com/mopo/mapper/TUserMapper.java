package com.mopo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.mopo.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 莫秃
 * @since 2021-04-10
 */

@Repository
public interface TUserMapper extends BaseMapper<TUser> {
}
