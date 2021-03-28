package Dao;

import Model.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();
    List<User> getUserById(int id);
    int insertUser(User user);
}
