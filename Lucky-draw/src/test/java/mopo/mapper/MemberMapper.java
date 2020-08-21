package mopo.mapper;

import mopo.base.BaseMapper;
import mopo.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper extends BaseMapper<Member> {
}