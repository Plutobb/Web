package action;

import JDBC.DBUtil;
import model.Bill;
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
        System.out.println("输入要查询的客户名:");
        String name = sc.next();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            String sql = "select Cnum, Cname, Ctel, Caddr, Ccom from customer where Cname = ?";
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
                System.out.println(customer.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("查询客户信息出错!",e);
        } finally {
            DBUtil.Close(c,ps,rs);
        }
    }

    //根据客户号查询所有订单;
    public static void  selectByCustomerNum(){

        //输入要查询的客户号
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入客户号:");
        int num = sc.nextInt();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            String sql = "select Listnum from list where Cnum = ?";
            ps = c.prepareStatement(sql);
            //替换掉占位符实现查询操作;
            ps.setInt(1,num);
            rs = ps.executeQuery();
            System.out.println("该客户拥有的订单号:");
            while (rs.next()){
                List list = new List();
                list.setListnum(rs.getInt("Listnum"));
                System.out.println(list.getListnum());
            }
        } catch (Exception e) {
            throw new RuntimeException("查询客户订单信息出错!",e);
        } finally {
            DBUtil.Close(c,ps,rs);
        }
    }

    //根据订单号查询
    public static void  selectByListNum(){

        //输入要查询的订单号
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入订单号:");
        int listNum = sc.nextInt();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            String sql = "select c.Cname,b.Billnum,g2.Goodname,g2.Goodprice,g.BuyNum ,g2.Goodprice*g.BuyNum as total ,b.PayMethod from list\n" +
                    "     join goodslist g on list.Listnum = g.ListNum\n" +
                    "     join customer c on list.Cnum = c.Cnum\n" +
                    "     join goods g2 on g.Goodnum = g2.Goodnum\n" +
                    "join bill b on list.Billnum = b.Billnum\n" +
                    "where list.Listnum = ?;";
            ps = c.prepareStatement(sql);
            //替换掉占位符实现查询操作;
            ps.setInt(1,listNum);
            rs = ps.executeQuery();
            int sum = 0;
            while (rs.next()){
                List list = new List();
                list.setBillnum(rs.getInt("Billnum"));
                list.setCname(rs.getString("Cname"));
                list.setPayMethod(rs.getString("PayMethod"));
                list.setGoodname(rs.getString("Goodname"));
                list.setGoodprice(rs.getInt("Goodprice"));
                list.setBuyNum(rs.getInt("BuyNum"));
                list.setTotal(rs.getInt("total"));
                sum = sum + rs.getInt("total");
                System.out.println(list.toString());
            }
            System.out.println("总金额为: "+ sum +"元");
        } catch (Exception e) {
            throw new RuntimeException("查询客户信息出错!",e);
        } finally {
            DBUtil.Close(c,ps,rs);
        }
    }

    public static void  selectAllGoods(){

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            String sql = "select goodnum, goodname, goodprice, goodstore from goods;";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Goods goods = new Goods();
                goods.setGoodnum(rs.getInt("goodnum"));
                goods.setGoodname(rs.getString("goodname"));
                goods.setGprice(rs.getString("goodprice"));
                goods.setGstore(rs.getInt("goodstore"));
                System.out.println(goods.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("查询所有商品信息出错!",e);
        } finally {
            DBUtil.Close(c,ps,rs);
        }
    }

    public static void  selectByGoodsNum(){
        //输入要查询的商品号
        Scanner sc = new Scanner(System.in);
        int GoodsNum = sc.nextInt();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            String sql = "select goodnum, goodname, goodprice, goodstore " +
                    "from goods " +
                    "where Goodnum = ?";
            ps = c.prepareStatement(sql);
            ps.setInt(1,GoodsNum);
            rs = ps.executeQuery();
            while (rs.next()){
                Goods goods = new Goods();
                goods.setGoodnum(rs.getInt("goodnum"));
                goods.setGoodname(rs.getString("goodname"));
                goods.setGprice(rs.getString("goodprice"));
                goods.setGstore(rs.getInt("goodstore"));
                System.out.println(goods.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("查询单个商品信息出错!",e);
        } finally {
            DBUtil.Close(c,ps,rs);
        }
    }

    public static void total(int billNum){

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            String sql = "select c.Cname,b.Billnum,g2.Goodname,g2.Goodprice,g.BuyNum ,g2.Goodprice*g.BuyNum as total ,b.PayMethod from list\n" +
                    "     join goodslist g on list.Listnum = g.ListNum\n" +
                    "     join customer c on list.Cnum = c.Cnum\n" +
                    "     join goods g2 on g.Goodnum = g2.Goodnum\n" +
                    "join bill b on list.Billnum = b.Billnum\n" +
                    "where list.Listnum = ?;";
            ps = c.prepareStatement(sql);
            //替换掉占位符实现查询操作;
            ps.setInt(1,billNum);
            rs = ps.executeQuery();
            int sum = 0;
            while (rs.next()){
                sum = sum + rs.getInt("total");
            }
            System.out.println("总金额为: "+ sum +"元");
        } catch (Exception e) {
            throw new RuntimeException("查询总金额信息出错!",e);
        } finally {
            DBUtil.Close(c,ps,rs);
        }
    }

    public static void  selectByBillNum(){
        //输入要查询的发票号
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要查询的发票号:");
        int BillNum = sc.nextInt();



        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            String sql = "select billnum,c.Cname, listnum, paymethod from bill\n" +
                    "join customer c on bill.Cnum = c.Cnum\n" +
                    "where Billnum = ?;";
            ps = c.prepareStatement(sql);
            ps.setInt(1,BillNum);
            rs = ps.executeQuery();
            while (rs.next()){
                Bill bill = new Bill();
                bill.setBillnum(rs.getInt("billnum"));
                bill.setListNum(rs.getInt("listnum"));
                bill.setCname(rs.getString("Cname"));
                bill.setPayMethod(rs.getString("paymethod"));
                System.out.println(bill.toString());
            }
            action.select.total(BillNum);
        } catch (Exception e) {
            throw new RuntimeException("查询发票信息出错!",e);
        } finally {
            DBUtil.Close(c,ps,rs);
        }
    }


}
