package action;

import JDBC.DBUtil;
import model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class select {
    //根据学号查询;
    public static void selectByNum(){
        List<model.user> users = new LinkedList<user>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select num,name from users";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                user user =new user();
                user.setNum(rs.getInt("num"));
                user.setName(rs.getString("name"));
                System.out.println(user.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("查询全部信息出错!",e);
        } finally {
            DBUtil.Close(c,ps,rs);
        }
    }
}
