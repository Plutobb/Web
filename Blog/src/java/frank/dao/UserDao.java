package frank.dao;

import frank.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    public static boolean login(String userName, String passWord) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1.获取数据库连接
            c = DBUtil.getConnection();
            String sql = "select users.id from users where userName = ? and passWord = ?;";
            //2.创建操作命令对象
            ps = c.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,passWord);
            //3.执行sql
            rs = ps.executeQuery();
            //4.处理结果集
            if (rs.next()){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException("查询文章列表出错，一般都是自己sql写错了，或方法调用出错", e);
        } finally {//5.释放资源
            DBUtil.close(c, ps, rs);
        }
    }
}
