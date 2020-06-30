import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.*;

public class Test1 {
    //（1）用逗号隔开的数字序列读取。
    //（2）设计完成序列逆序的方法。
    //（3）设计完成序列排序的方法。
    //（4）设计完成序列平均值计算的方法。
    //（5）设计一种算法，找出最接近平均值的数字，并显示其在序列中的位置。
    //读取用逗号隔开的数字,然后放入链表中;
    public static List<Integer> duQu(){
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String allNum = sc.next();
        String[] num = new String[0];
        for (int i = 0; i < allNum.length(); i++) {
            num = allNum.split(",");
        }
        System.out.print("读取结果:");
        for (String str : num){
            list.add(Integer.valueOf(str));
            System.out.print(str+" ");
        }
        System.out.println();
        return list;
    }
    //逆序链表中的数字;
    public static List<Integer> niXu(List<Integer> list){
        List<Integer> niXuList = new ArrayList<>();
        for (int i = list.size()-1; i >= 0; i--) {
            niXuList.add(list.get(i));
        }
        System.out.print("逆序:");
        for (Integer integer : niXuList) {
            System.out.print(integer+" ");
        }
        System.out.println();
        return niXuList;
    }
    //这里用的是自带的排序;
    public static void sort(List<Integer> list){
        list.sort((o1, o2) -> o1 - o2);
        System.out.print("排序升序:");
        for (int num : list){
            System.out.print(num+" ");
        }
        System.out.println();
        list.sort((o1, o2) -> o2 - o1);
        System.out.print("排序降序:");
        for (int num : list){
            System.out.print(num+" ");
        }
        System.out.println();
    }
    //平均值计算
    public static double avg(List<Integer> list){
        int n = 0;
        int sum = 0;
        double avg = 0.0;
        for (int num : list){
            sum += num;
            n++;
        }
        avg =(double) sum / n;
        System.out.print("平均值:");
        System.out.printf("%.2f",avg);
        System.out.println();
        return avg;
    }
    //找出最接近平均值的数字和下标;
    public static void findIndex(List<Integer> list,double avg){
        double minCha = Integer.MAX_VALUE;
        int num = 0;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            //差值越小离平均值越近;
            double cha = Math.abs(list.get(i) - avg);
            if (cha < minCha){
                minCha = cha;
                num = list.get(i);
                index = i;
            }
        }
        System.out.print("最接近的数字和下标:");
        System.out.print(num+" "+index);
        System.out.println();
    }
    public static void main(String[] args) {
        List<Integer> list = duQu();
        niXu(list);
        sort(list);
        double avg = avg(list);
        findIndex(list,avg);
    }
}
