package mopo.mapper;

import mopo.base.BaseMapper;
import mopo.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}