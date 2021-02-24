package dao;

import entity.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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

    public List<User> find() {
        List<User> list = new LinkedList<User>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = DBUtil.getConnection();
            String sql ="select * from users;";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("users_id");
                String name = rs.getString("users_name");
                String password = rs.getString("users_password");
                User user = new User(id,name,password);
                list.add(user);
            }
        } catch (SQLException throwables) {
            System.out.println("用户信息查询错误!");
            throwables.printStackTrace();
        } finally {
            DBUtil.Close(connection,ps,rs);
        }
        return list;
    }

    public int delete(int userId) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        c = DBUtil.getConnection();
        String sql = "delete from users where users_id = ?;";
        ps = c.prepareStatement(sql);
        ps.setInt(1,userId);
        return ps.executeUpdate();
    }
}
