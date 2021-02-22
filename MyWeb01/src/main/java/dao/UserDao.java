package dao;

import entity.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    public int add(User user){
        int rs = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBUtil.getConnection();
            String  sql = "insert into users(users_name, users_password) values (?,?);";
            ps = connection.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("用户信息插入错误!");
            throwables.printStackTrace();
        }finally {
            DBUtil.Close(connection,ps);
        }
        return rs;
    }
}
