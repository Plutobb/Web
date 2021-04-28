package com.mopo.mapper;

import com.mopo.entity.TType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface TTypeMapper extends BaseMapper<TType> {

    @Select("select ty.id,ty.name,count(tb.id) as blogCount from t_type ty left join t_blog tb on ty.id = tb.type_id group by ty.id")
    List<TType> getTypesAndBlogCount();
}
