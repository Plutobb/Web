package dao;

import entity.User;
import util.DBUtil;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserDao {
    //------------------------------重写方法 start---------------------------------------
    public int add(User user, ServletContext context){
        Connection con = null;
        PreparedStatement ps = null;
        int rs = 0;
        Map map = (Map) context.getAttribute("key1");
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            con = (Connection) iterator.next();
            if ((Boolean) map.get(con)){
                map.put(con,false);
                break;
            }
        }
        try {
            String  sql = "insert into users(users_name, users_password) values (?,?);";
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            map.put(con,true);
            DBUtil.Close(con,ps);
        }
        return rs;
    }

    //-----------------------------------end--------------------------------------------

    public int add(User user){
        int rs = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            Date date = new Date();
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
        int rs = 0;

        try {
            c = DBUtil.getConnection();
            String sql = "delete from users where users_id = ?;";
            ps = c.prepareStatement(sql);
            ps.setInt(1,userId);
            rs = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.Close(c,ps);
        }

        return rs;
    }

    public Boolean login(String name,String password) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean login = false;

        try {
            c = DBUtil.getConnection();
            String sql = "select users_id from users where users_name = ? and users_password = ?;";
            ps = c.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,password);
            rs = ps.executeQuery();
            login = rs.next();
        } catch (SQLException throwables) {
            System.out.println("用户登录错误!");
            throwables.printStackTrace();
        } finally {
            DBUtil.Close(c,ps,rs);
        }
        return login;
    }
}
