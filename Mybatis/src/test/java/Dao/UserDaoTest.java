package Dao;

import Model.User;
import Until.MybatisUntil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUntil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for(User user : userList){
            System.out.println(user.getPassWord());
        }
    }
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUntil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("张", "1888");
        mapper.insertUser(user);

        sqlSession.close();
    }
    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUntil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.getUserById(1);
        for (User user1 : user){
            System.out.println(user1);
        }
    }
}
