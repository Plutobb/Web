package action;

import JDBC.DBUtil;
import model.Customer;
import model.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

public class Build {

    //新增商品;
    public static void BuildGoods(){
        String GoodsName;
        String GoodsPrice;
        int GoodsStore;
        Scanner sc = new Scanner(System.in);
        System.out.println("输入商品名称:");
        GoodsName = sc.next();
        System.out.println("输入商品价格:");
        GoodsPrice = sc.next();
        System.out.println("输入商品库存:");
        GoodsStore = sc.nextInt();

        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = DBUtil.getConnection();
            String sql = "insert into goods(goodname, goodprice, goodstore) VALUES (?,?,?) ";
            ps = c.prepareStatement(sql);
            ps.setString(1,GoodsName);
            ps.setString(2,GoodsPrice);
            ps.setInt(3,GoodsStore);
            ps.execute();
            System.out.println("商品插入成功!");
        } catch (Exception e) {
            throw new RuntimeException("插入商品信息出错!",e);
        } finally {
            DBUtil.Close(c,ps);
        }
    }

    //新建客户;
    public static void BuildCustomer(){
        Scanner sc = new Scanner(System.in);
        model.Customer customer = new Customer();
        System.out.println("请输入客户名:");
        customer.setCname(sc.next());
        System.out.println("请输入客户电话:");
        customer.setCtel(sc.next());
        System.out.println("请输入客户地址:");
        customer.setCaddr(sc.next());
        System.out.println("请输入客户公司:");
        customer.setCcom(sc.next());

        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = DBUtil.getConnection();
            String sql = "insert into customer(cname, ctel, caddr, ccom) values (?,?,?,?); ";
            ps = c.prepareStatement(sql);
            ps.setString(1,customer.getCname());
            ps.setString(2,customer.getCtel());
            ps.setString(3,customer.getCaddr());
            ps.setString(4,customer.getCcom());
            ps.execute();
            System.out.println("客户插入成功!");
        } catch (Exception e) {
            throw new RuntimeException("插入客户信息出错!",e);
        } finally {
            DBUtil.Close(c,ps);
        }

    }
    //新建发票;
    static int Cnum = 0;
    static int ListNum = 0;
    public static void BuildBill(){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入客户号:");
        Cnum = sc.nextInt();
        System.out.println("订单号:");
        ListNum = sc.nextInt();
        System.out.println("输入支付方式:");
        String payMethod = sc.next();

        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = DBUtil.getConnection();
            String sql = "insert into bill(cnum, listnum,  paymethod) values (?,?,?); ";
            ps = c.prepareStatement(sql);
            ps.setInt(1,Cnum);
            ps.setInt(2,ListNum);
            ps.setString(3,payMethod);
            ps.execute();
            System.out.println("发票信息建立成功!");
        } catch (Exception e) {
            throw new RuntimeException("发票信息出错!",e);
        } finally {
            DBUtil.Close(c,ps);
        }
    }
    //新建订单;
    public static void BuildList(){
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            String sql = "insert into List(Billnum, Cnum) VALUES (?,?); ";
            ps = c.prepareStatement(sql);
            ps.setInt(1,ListNum);
            ps.setInt(2,Cnum);
            ps.execute();
            System.out.println("订单数据信息建立成功!");
        } catch (Exception e) {
            throw new RuntimeException("订单信息出错!",e);
        } finally {
            DBUtil.Close(c,ps);
        }
    }

    public static void BuildBuyGoods(){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要购买的商品号:");
        int goodNum = sc.nextInt();
        System.out.println("输入要购买的数量:");
        int buyNum = sc.nextInt();
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            String sql = "insert into goodslist(goodnum, buynum,ListNum) VALUES (?,?,?); ";
            ps = c.prepareStatement(sql);
            ps.setInt(1,goodNum);
            ps.setInt(2,buyNum);
            ps.setInt(3,ListNum);
            ps.execute();
            System.out.println("物品已加入订单!");
        } catch (Exception e) {
            throw new RuntimeException("插入客户信息出错!",e);
        } finally {
            DBUtil.Close(c,ps);
        }
    }


    //建立完整的订单信息
    public static void BuildNewList(){
        action.Build.BuildCustomer();
        action.Build.BuildBill();
        action.Build.BuildList();
        System.out.println("输入购买物品的种类个数:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            action.Build.BuildBuyGoods();
        }
    }
}
