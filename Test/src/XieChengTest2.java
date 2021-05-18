import java.util.Scanner;

public class XieChengTest2 {
    public static void main(String[] args) {
        //根据结束时间可以列出所有的订单排列
        //注意点就是 上一个订单的结束时间要小于等于第二个订单的开始时间;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int total = sc.nextInt();
            int[] beginTime = new int[total];
            int[] endTime = new int[total];
            int[] zuJin = new int[total];
            for (int i = 0; i < total; i++) {
                beginTime[i] = sc.nextInt();
            }

            for (int i = 0; i < total; i++) {
                endTime[i] = sc.nextInt();
            }

            for (int i = 0; i < total; i++) {
                zuJin[i] = sc.nextInt();
            }

            int ans = maxZuJin(beginTime,endTime,zuJin);
            System.out.println(ans);
        }
    }

    private static int maxZuJin(int[] beginTime, int[] endTime, int[] zuJin) {
        int maxZuJin = 0;
        for (int i = 0; i < beginTime.length; i++) {
            int sum = zuJin[i];
            int end = endTime[i];
            int index = i+1;
            while (index < beginTime.length){
                if (beginTime[index] >= end){
                    sum += zuJin[index];
                    end = endTime[index];
                }
                index++;
            }
            if (sum > maxZuJin){
                maxZuJin = sum;
            }
        }
        return maxZuJin;
    }
}
