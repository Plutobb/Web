package Dao;

import Model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();

    @Select("select * from user where id = #{id}")
    List<User> getUserById(@Param("id") int id);

    @Insert("insert into user(userName,passWord) values(#{userName},#{passWord})")
    void insertUser(User user);

    @Delete("delete from user where id = #{id};")
    void deleteUserById(@Param("id") int id);

}
