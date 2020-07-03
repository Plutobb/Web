import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zuoye1 {
    public  int[] HuoQuShuZi(){
        Scanner sc = new Scanner(System.in);
        String shuRu = sc.next();
        String[] num = {};
        for (int i = 0; i < shuRu.length(); i++) {
            num = shuRu.split(",");
        }
        int[] jieGuo =new  int[num.length];
        for (int i = 0; i < num.length; i++) {
            jieGuo[i] = Integer.parseInt(num[i]);
        }
        return jieGuo;
    }
    public int[] niXu(int[] num){
        int[] niXu =new int[num.length];
        int index = num.length-1;
        for (int i = 0; i < num.length; i++) {
            niXu[index] = num[i];
            index--;
        }
        return niXu;
    }
    public void findPingJun(int[] shuZu,double avg){
        double zuiXiaoJuLi = -100;
        int num = 0;
        int xiaBiao = 0;
        for (int i = 0; i < shuZu.length; i++) {
            double juLi = Math.abs(shuZu[i] - avg);
            if (juLi < zuiXiaoJuLi){
                zuiXiaoJuLi = juLi;
                num = shuZu[i];
                xiaBiao = i;
            }
        }
        System.out.print("最接近的数字和下标:");
        System.out.print(num+" "+xiaBiao);
    }
    public double pingJun(int[] num){
        int n = 0;
        int sum = 0;
        double PingJun = 0.0;
        for (int x : num){
            sum =sum + x;
            n++;
        }
        PingJun =(double) sum / n;
        return PingJun;
    }
    public int[] sort(int[] num){
        int[] sortNum = num;
        for (int i = 0; i < sortNum.length-1; i++) {
            for (int j = 0; j < sortNum.length-1; j++) {
                if (sortNum[j] > sortNum[j+1]){
                    int tmp = sortNum[j];
                    sortNum[j] = sortNum[j+1];
                    sortNum[j+1] = tmp;
                }
            }
        }
        return sortNum;
    }
    public static void main(String[] args) {
        zuoye1 zuoye1 = new zuoye1();
        int[] shuRu =  zuoye1.HuoQuShuZi();
        for (int num : shuRu){
            System.out.print(num);
        }
        System.out.println();
        int[] nixu = zuoye1.niXu(shuRu);
        for (int num: nixu){
            System.out.print(num);
        }
        System.out.println();
        int[] paiXu = zuoye1.sort(shuRu);
        for (int num : paiXu){
            System.out.println(num);
        }
    }
}
