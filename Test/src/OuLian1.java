import java.util.Scanner;

public class OuLian1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String time = sc.next();
            findMinTime(time);
        }
    }

    private static String findMinTime(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int fen = Integer.parseInt(time.substring(3,5));

        //先对分进行判断如果能找到比输入大的则小时可以不改变,
        //如果找不出来大的则需要找出最小的分钟,和比输入大的小时;
        int minFen = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder(time);
        sb.delete(2,3);
        for (int i = 0; i < sb.length(); i++) {
            for (int j = 0; j < sb.length(); j++) {
                StringBuilder sbFen = new StringBuilder();
                int testFen = Integer.parseInt(sbFen.append(sb.charAt(i)).append(sb.charAt(j)).toString());
                if (testFen > fen && testFen < 60 && testFen < minFen){
                    minFen = testFen;
                }
            }
        }
        if (minFen != Integer.MAX_VALUE){
            StringBuilder ans = new StringBuilder(time);
            String minFenInteger = Integer.toString(minFen);
            ans.replace(3,5,minFenInteger);
            System.out.println(ans);
            return ans.toString();
        }else {
            int minHour = Integer.MAX_VALUE;
            int zuiXiaoFen = Integer.MAX_VALUE;
            for (int i = 0; i < sb.length(); i++) {
                for (int j = 0; j < sb.length(); j++) {
                    StringBuilder sbFen = new StringBuilder();
                    int testHour = Integer.parseInt(sbFen.append(sb.charAt(i)).append(sb.charAt(j)).toString());
                    if (testHour < 24 && testHour < minHour){
                        minHour = testHour;
                    }
                    if (testHour >= 0 && testHour<60 && testHour < zuiXiaoFen){
                        zuiXiaoFen = testHour;
                    }
                }
            }
            StringBuilder ans = new StringBuilder(time);
            String minHourInteger = Integer.toString(minHour);
            String zuiXiaoFenInt = Integer.toString(zuiXiaoFen);
            ans.replace(0,2,minHourInteger);
            ans.replace(3,5,zuiXiaoFenInt);
            System.out.println(ans);
            return ans.toString();
        }
    }
}
