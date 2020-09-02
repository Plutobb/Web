package action;

import JDBC.DBUtil;
import model.Customer;
import model.Goods;
import model.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class select {
    //根据客户名查询;
    public static void  selectByCustomerName(){

        //输入要查询的客户名
        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            String sql = "select Cnum, Cname, Ctel, Caddr, Ccom, Listnum from customer where Cname = ?";
            ps = c.prepareStatement(sql);
            //替换掉占位符实现查询操作;
            ps.setString(1,name);
            rs = ps.executeQuery();
            while (rs.next()){
                Customer customer = new Customer();
                customer.setCnum(rs.getInt("Cnum"));
                customer.setCname(rs.getString("Cname"));
                customer.setCtel(rs.getString("Ctel"));
                customer.setCcom(rs.getString("Ccom"));
                customer.setListnum(rs.getString("Listnum"));
                System.out.println(customer.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("查询客户信息出错!",e);
        } finally {
            DBUtil.Close(c,ps,rs);
        }
    }

    //根据订单号查询
    public static void  selectByListNum(){

        //输入要查询的订单号
        Scanner sc = new Scanner(System.in);
        int listNum = sc.nextInt();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            String sql = "select l.Listnum,l.Billnum,c.Cname,g.Goodname,l.Goodnum,b.PayMethod\n" +
                    "from list l\n" +
                    "join bill b on l.Billnum = b.Billnum\n" +
                    "join customer c on b.Cnum = c.Cnum\n" +
                    "join goods g on l.Goodnum = g.Goodnum where l.Listnum = ?;";
            ps = c.prepareStatement(sql);
            //替换掉占位符实现查询操作;
            ps.setInt(1,listNum);
            rs = ps.executeQuery();
            while (rs.next()){
                List list = new List();
                list.setListnum(rs.getInt("Listnum"));
                list.setBillnum(rs.getInt("Billnum"));
                list.setCname(rs.getString("Cname"));
                list.setPayMethod(rs.getString("PayMethod"));
                list.setGoodname(rs.getString("Goodname"));
                list.setGoodnum(rs.getInt("Goodnum"));
                System.out.println(list.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("查询客户信息出错!",e);
        } finally {
            DBUtil.Close(c,ps,rs);
        }
    }


}
