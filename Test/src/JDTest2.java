import java.util.LinkedList;
import java.util.Scanner;

public class JDTest2 {

    static int num;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (sc.hasNextInt()){
            num = 0;
            n = sc.nextInt();
            LinkedList<Integer> list = new LinkedList();
            list.add(0);
            help(n, list);
            System.out.println(num%998244353);
        }
    }

    public static void help(int n, LinkedList<Integer> list){
        if (list.size() == n+1 && list.getLast() == n){
            num++;
            return;
        }
        if (list.size() == n+1){
            return;
        }
        if (list.size() > n+1){
            return;
        }
        int last = list.getLast();
        if (!list.contains(last+1) && last+1 <= n){
            list.add(last+1);
            help(n,list);
            list.removeLast();
        }
        if (!list.contains(last-1)&& last-1 > 0){
            list.add(last-1);
            help(n,list);
            list.removeLast();
        }
        if (!list.contains(last+2) && last+2 <= n){
            list.add(last+2);
            help(n,list);
            list.removeLast();
        }
        if (!list.contains(last-2) && last-2 > 0){
            list.add(last-2);
            help(n,list);
            list.removeLast();
        }
        return;
    }
}
