package Windows;

import java.util.Scanner;

public class windows {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("==========欢迎来到客户订购登记系统============");
        System.out.println("=============1.客户模块====================");
        System.out.println("=============2.订单模块====================");
        System.out.println("=============3.发票模块====================");
        System.out.println("=============4.商品模块====================");
        System.out.println("=============5.退出系统====================");
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("请输入你的模块选择:");
        int choice = 0;
        try {
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
        } catch (Exception e) {
            System.out.println("输入有误!请重新输入:");
            menu();
        }
        switch (choice){
            case 1 :    CustomerModule();menu(); break;
            case 2 :    ListModule();menu();break;
            case 3 :    BillModule();menu();break;
            case 4 :    GoodsModule();menu();break;
            case 5 :
                System.out.println("再见!");break;
            default:
                System.out.println("输入有误!请重新选择:");
                menu();
        }
    }

    //客户模块
    public static void CustomerModule(){
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("===============客户模块====================");
        System.out.println("=============1.通过客户名查询客户信息=========");
        System.out.println("=============2.通过客户号查询客户订单========");
        System.out.println("=============3.新增客户====================");
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("请输入你的选择:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1 :    action.select.selectByCustomerName();break;
            case 2 :    action.select.selectByCustomerNum();break;
            case 3 :    action.Build.BuildCustomer();break;
            default:
                System.out.println("输入有误!请重新选择:");
                CustomerModule();
        }
    }

    //订单模块
    public static void ListModule(){
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("===============订单模块====================");
        System.out.println("=============1.通过订单号查询===============");
        System.out.println("=============2.新建订单====================");
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("请输入你的选择:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1 :    action.select.selectByListNum();break;
            case 2 :    action.Build.BuildNewList();break;
            default:
                System.out.println("输入有误!请重新选择:");
                ListModule();
                break;
        }
    }
    //发票模块
    public static void BillModule(){
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("===============发票模块====================");
        System.out.println("=============1.通过发票号查询===============");
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("请输入你的选择:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice == 1){
            action.select.selectByBillNum();
        }else {
            System.out.println("输入有误!请重新输入!");
            BillModule();
        }
    }

    //商品模块
    public static void GoodsModule(){
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("===============商品模块====================");
        System.out.println("=============1.查询所有商品================");
        System.out.println("=============2.新增商品====================");
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("请输入你的选择:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1 :    action.select.selectAllGoods();break;
            case 2 :    action.Build.BuildGoods();break;
            default:
                System.out.println("输入有误!请重新选择:");
                GoodsModule();
        }
    }
}
